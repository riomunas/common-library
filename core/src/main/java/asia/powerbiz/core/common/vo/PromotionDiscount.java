package asia.powerbiz.core.common.vo;

import asia.powerbiz.core.salesorder.constant.DiscountType;
import asia.powerbiz.core.salesorder.constant.PromotionSourceType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PromotionDiscount {
    private DiscountType type;
    private String code;
    private PromotionSourceType source;
    private BigDecimal value;

    public PromotionDiscount(DiscountType type, PromotionSourceType source, BigDecimal value) {
        this.type = type;
        this.source = source;
        this.value = value;
    }

}
