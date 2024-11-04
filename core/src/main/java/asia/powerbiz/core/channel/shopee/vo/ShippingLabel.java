package asia.powerbiz.core.channel.shopee.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingLabel {
    private String orderSn;
    private String shippingLabelUrl;
    private String attribute;
}
