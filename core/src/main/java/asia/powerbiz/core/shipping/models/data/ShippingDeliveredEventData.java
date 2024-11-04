package asia.powerbiz.core.shipping.models.data;

import asia.powerbiz.core.shipping.constant.ShippingState;

import java.time.Instant;
import java.util.UUID;

public record ShippingDeliveredEventData(
        String fulfillmentId,
        UUID orderId,
        String awbNumber,
        String referenceNumber,
        Long channelId,
        ShippingState shippingState,
        Instant deliveredTimestamp

) {
}
