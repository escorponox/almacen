package jpa;

import javax.persistence.*;

@Entity
@Table(name = "LOCATE_ACTIONS", schema = "PROYECTO", catalog = "")
public class LocateAction {
    private Long id;
    private ActionStatus status;
    private ReceiptAction receiptAction;
    private User picker;

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

        LocateAction that = (LocateAction) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "STATUS", referencedColumnName = "ID", nullable = false)
    public ActionStatus getStatus() {
        return status;
    }

    public void setStatus(ActionStatus actionStatusByStatus) {
        this.status = actionStatusByStatus;
    }

    @ManyToOne
    @JoinColumn(name = "RECEIPT_ACTION_ID", referencedColumnName = "ID", nullable = false)
    public ReceiptAction getReceiptAction() {
        return receiptAction;
    }

    public void setReceiptAction(ReceiptAction receiptActionsByReceiptActionId) {
        this.receiptAction = receiptActionsByReceiptActionId;
    }

    @ManyToOne
    @JoinColumn(name = "PICKER_ID", referencedColumnName = "ID")
    public User getPicker() {
        return picker;
    }

    public void setPicker(User userByPickerId) {
        this.picker = userByPickerId;
    }
}
