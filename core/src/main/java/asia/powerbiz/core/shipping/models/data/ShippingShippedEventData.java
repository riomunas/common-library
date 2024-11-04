package asia.powerbiz.core.shipping.models.data;

import asia.powerbiz.core.shipping.constant.ShippingState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShippingShippedEventData(
        UUID orderId,
        UUID fulfillmentId,
        String awbNumber,
        String referenceNumber,
        Long channelId,
        ShippingState shippingState,
        Instant pickUpTimestamp
) {
}
