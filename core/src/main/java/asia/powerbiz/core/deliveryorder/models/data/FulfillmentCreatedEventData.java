package asia.powerbiz.core.deliveryorder.models.data;

import asia.powerbiz.core.common.vo.*;
import asia.powerbiz.core.deliveryorder.constant.FulfillmentState;
import asia.powerbiz.core.deliveryorder.vo.DeliveryItem;
import asia.powerbiz.core.inventory.constant.BookingState;
import asia.powerbiz.core.salesorder.constant.OrderState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FulfillmentCreatedEventData(
        @JsonProperty("id") UUID id,
        @JsonProperty("fulfillmentNumber") String fulfillmentNumber,
        @JsonProperty("fulfillmentId") String fulfillmentId,
        @JsonProperty("orderId") UUID orderId,
        @JsonProperty("orderNumber") String orderNumber,
        @JsonProperty("businessId") String businessId,
        @JsonProperty("orderDate") OffsetDateTime orderDate,
        @JsonProperty("state") FulfillmentState state,
        @JsonProperty("orderState") OrderState orderState,
        @JsonProperty("bookingState") BookingState bookingState,
        @JsonProperty("warehouseId") String warehouseId,
        @JsonProperty("hubId") String hubId,
        @JsonProperty("channel") Channel channel,
        @JsonProperty("goodsValue") Money goodsValue,
        @JsonProperty("destination") ShippingContact destination,
        @JsonProperty("sender") ShippingContact sender,
        @JsonProperty("shipping") ShippingData shipping,
        @JsonProperty("lineItems") List<DeliveryItem> lineItems,
        @JsonProperty("customer") Customer customer,
        @JsonProperty("warehouseName") String warehouseName,
        @JsonProperty("wmsCode") String wmsCode,
        @JsonProperty("wmsCategories") String wmsCategories,
        @JsonProperty("deliveryMethod") DeliveryMethod deliveryMethod,
        @JsonProperty("sla") Instant sla
) {
}
