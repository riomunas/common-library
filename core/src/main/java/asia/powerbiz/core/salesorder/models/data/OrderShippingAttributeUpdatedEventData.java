package asia.powerbiz.core.salesorder.models.data;

import asia.powerbiz.core.shipping.vo.ShippingLabel;

import java.util.UUID;

public record OrderShippingAttributeUpdatedEventData(
        UUID orderId,
        ShippingLabel shippingLabel
) {
}
