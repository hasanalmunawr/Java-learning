package hasanalmudev.belajarjavavalidation1;

import hasanalmudev.belajarjavavalidation1.constraint.CheckOrderId;
import hasanalmudev.belajarjavavalidation1.group.CreditCardPaymentGroup;
import hasanalmudev.belajarjavavalidation1.group.VirtualAccountPaymentGroup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class Payment {

   @CheckOrderId(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
           message = "{order.id.checkid}")
    private String orderId;

    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            message = "{order.amount.notnull}")
    @Range(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            min = 10_000, max = 1_000_000_000, message = "{order.amount.range}")
    private Long amount;

    @LuhnCheck(groups ={CreditCardPaymentGroup.class},
            message = "{order.creditcard.lunkcheck}")
    @NotBlank(groups = {CreditCardPaymentGroup.class},
            message = "{order.creditcard.notblank}",
    payload = {EmailErrorPayload.class})
    private String creditcard;

    @NotBlank(groups = {VirtualAccountPaymentGroup.class},
            message = "{order.virtualaccount.notblank}")
    private String virtualAccount;

    @Valid
    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            message = "{order.customer.notnull}")
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(String creditcard) {
        this.creditcard = creditcard;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditcard='" + creditcard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                ", customer=" + customer +
                '}';
    }
}
