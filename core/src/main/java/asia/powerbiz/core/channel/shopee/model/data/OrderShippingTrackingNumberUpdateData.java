package asia.powerbiz.core.channel.shopee.model.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderShippingTrackingNumberUpdateData(
        String orderNumber,
        String packageNumber,
        String trackingNumber,
        Long shopId
) {
}
