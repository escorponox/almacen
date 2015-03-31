package services;

import forms.SelectMonthForm;
import forms.ShowSalaryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.utils.salary.SalaryCalculator;

@Service
public class SalaryService {

    @Autowired
    private SalaryCalculator salaryCalculator;


    public ShowSalaryForm calculateSalary(SelectMonthForm selectMonthForm, String username) {

        return salaryCalculator.calculate(selectMonthForm, username);
    }
}
