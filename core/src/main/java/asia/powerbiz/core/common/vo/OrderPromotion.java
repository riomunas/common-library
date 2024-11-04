package asia.powerbiz.core.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderPromotion {
    private List<PromotionDiscount> discounts;

    public OrderPromotion(PromotionDiscount... promotionDiscounts){
        this.discounts = new ArrayList<>();
        this.discounts.addAll(Arrays.asList(promotionDiscounts));
    }
}
