package hasanalmunawarDev.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions_credit_card")
public class TransactionCredit extends Transaction {

    @Column(name = "credit_amount")
    private Long creaditAmount;

    public Long getCreaditAmount() {
        return creaditAmount;
    }

    public void setCreaditAmount(Long creaditAmount) {
        this.creaditAmount = creaditAmount;
    }
}
