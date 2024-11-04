package asia.powerbiz.core.salesorder.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderSellerAdminFee {
    private BigDecimal total = BigDecimal.ZERO;
    private OrderSellerAdminFee.Details details = new Details();

    public void calculateTotal() {
        total = details.getServiceFee()
                .add(details.getCommissionFee())
                .add(details.getOtherFee());
    }

    public OrderSellerAdminFee setServiceFee(BigDecimal serviceFee) {
        details.setServiceFee(serviceFee);
        this.calculateTotal();
        return this;
    }

    public OrderSellerAdminFee setCommissionFee(BigDecimal commissionFee) {
        details.setCommissionFee(commissionFee);
        this.calculateTotal();
        return this;
    }

    public OrderSellerAdminFee setOtherFee(BigDecimal otherFee) {
        details.setCommissionFee(otherFee);
        this.calculateTotal();
        return this;
    }

    @Data
    public static class Details {
        private BigDecimal serviceFee = BigDecimal.ZERO;
        private BigDecimal commissionFee = BigDecimal.ZERO;
        private BigDecimal otherFee = BigDecimal.ZERO;
    }
}
