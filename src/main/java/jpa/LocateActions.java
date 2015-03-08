package jpa;

import javax.persistence.*;

@Entity
@Table(name = "LOCATE_ACTIONS", schema = "PROYECTO", catalog = "")
public class LocateActions {
    private Long id;
    private ActionStatus actionStatusByStatus;
    private ReceiptActions receiptActionsByReceiptActionId;
    private Users usersByPickerId;

    @SequenceGenerator(name = "LOCATE_ACTIONS_SEQ", sequenceName = "LOCATE_ACTIONS_SEQ", allocationSize = 1)

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCATE_ACTIONS_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocateActions that = (LocateActions) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "STATUS", referencedColumnName = "ID", nullable = false)
    public ActionStatus getActionStatusByStatus() {
        return actionStatusByStatus;
    }

    public void setActionStatusByStatus(ActionStatus actionStatusByStatus) {
        this.actionStatusByStatus = actionStatusByStatus;
    }

    @ManyToOne
    @JoinColumn(name = "RECEIPT_ACTION_ID", referencedColumnName = "ID", nullable = false)
    public ReceiptActions getReceiptActionsByReceiptActionId() {
        return receiptActionsByReceiptActionId;
    }

    public void setReceiptActionsByReceiptActionId(ReceiptActions receiptActionsByReceiptActionId) {
        this.receiptActionsByReceiptActionId = receiptActionsByReceiptActionId;
    }

    @ManyToOne
    @JoinColumn(name = "PICKER_ID", referencedColumnName = "ID", nullable = false)
    public Users getUsersByPickerId() {
        return usersByPickerId;
    }

    public void setUsersByPickerId(Users usersByPickerId) {
        this.usersByPickerId = usersByPickerId;
    }
}
