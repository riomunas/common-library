package asia.powerbiz.core.deliveryorder.models.data;

import asia.powerbiz.core.common.vo.Channel;
import asia.powerbiz.core.deliveryorder.constant.FulfillmentState;
import asia.powerbiz.core.deliveryorder.vo.DeliveryItem;
import asia.powerbiz.core.salesorder.constant.OrderState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FulfillmentProcessUpdatedEventData(
        @JsonProperty("fulfillmentId") UUID fulfillmentId,
        @JsonProperty("orderId") UUID orderId,
        @JsonProperty("orderNumber") String orderNumber,
        @JsonProperty("orderState") OrderState orderState,
        @JsonProperty("businessId") String businessId,
        @JsonProperty("warehouseId") String warehouseId,
        @JsonProperty("channel") Channel channel,
        @JsonProperty("state") FulfillmentState state,
        @JsonProperty("lineItems") List<DeliveryItem> lineItems
) {
}
