package asia.powerbiz.core.shipping.models.data;

import asia.powerbiz.core.shipping.constant.ShippingState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AwbCreatedEventData(
        UUID orderId,
        String awb,
        UUID fulfillmentId,
        String referenceNumber,
        Long channelId,
        ShippingState shippingState


) {
}
