package asia.powerbiz.core.salesorder.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderBuyerAdminFee {
    private BigDecimal total = BigDecimal.ZERO;
    private OrderBuyerAdminFee.Details details = new Details();

    public void calculateTotal() {
        total = details.getTransactionFee()
                .add(details.getPaymentGatewayFee())
                .add(details.getOtherFee());
    }

    public OrderBuyerAdminFee setTransactionFee(BigDecimal transAdminFee) {
        this.details.setTransactionFee(transAdminFee);
        this.calculateTotal();
        return this;
    }

    public OrderBuyerAdminFee setPaymentGatewayFee(BigDecimal paymentAdminFee) {
        details.setPaymentGatewayFee(paymentAdminFee);
        this.calculateTotal();
        return this;
    }

    public OrderBuyerAdminFee setOtherFee(BigDecimal otherAdminFee) {
        details.setOtherFee(otherAdminFee);
        this.calculateTotal();
        return this;
    }

    @Data
    public static class Details {
        private BigDecimal transactionFee = BigDecimal.ZERO;
        private BigDecimal paymentGatewayFee = BigDecimal.ZERO;
        private BigDecimal otherFee = BigDecimal.ZERO;
    }
}
