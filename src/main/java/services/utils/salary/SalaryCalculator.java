package services.utils.salary;

import forms.SalaryOrder;
import forms.SelectMonthForm;
import forms.ShowSalaryForm;
import jpa.Order;
import jpa.User;
import jpa.dao.OrderDAO;
import jpa.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.utils.orders.OrderTotalAmountCalculator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class SalaryCalculator {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OrderTotalAmountCalculator orderTotalAmountCalculator;

    public ShowSalaryForm calculate(SelectMonthForm selectMonthForm, String username) {

        ShowSalaryForm showSalaryForm = new ShowSalaryForm();

        User user = userDAO.getUserByUsername(username);

        showSalaryForm.setMonth(new SimpleDateFormat("MM / yyyy").format(selectMonthForm.getMonth()));

        showSalaryForm.setCommission(user.getCommission());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectMonthForm.getMonth());


        calendar.add(Calendar.MONTH, 1);

        for (Order order : orderDAO.findOrdersBySellerAndPeriod(user, selectMonthForm.getMonth(), calendar.getTime())) {

            BigDecimal orderTotal = orderTotalAmountCalculator.calculate(order);
            BigDecimal orderCommission = orderTotal.multiply(user.getCommission()).setScale(2, BigDecimal.ROUND_CEILING);

            SalaryOrder salaryOrder = new SalaryOrder();
            salaryOrder.setOrderCode(order.getCode());
            salaryOrder.setOrderTotal(orderTotal);
            salaryOrder.setOrderCommission(orderCommission);

            showSalaryForm.getSalaryOrders().add(salaryOrder);

            showSalaryForm.setTotalSalary(showSalaryForm.getTotalSalary().add(orderCommission).setScale(2, BigDecimal.ROUND_CEILING));
        }

        return showSalaryForm;
    }
}
