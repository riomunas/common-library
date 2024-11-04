package asia.powerbiz.core.salesorder.models.data;

import asia.powerbiz.core.common.vo.*;
import asia.powerbiz.core.salesorder.constant.OrderState;
import asia.powerbiz.core.salesorder.vo.OrderBuyerAdminFee;
import asia.powerbiz.core.salesorder.vo.OrderSellerAdminFee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderCreatedEventData(
        @JsonProperty("id") UUID id,
        @JsonProperty("referenceId") String referenceId,
        @JsonProperty("businessId") String businessId,
        @JsonProperty("workspaceId") String workspaceId,
        @JsonProperty("orderNumber") String orderNumber,
        @JsonProperty("channel") Channel channel,
        @JsonProperty("customer") Customer customer,
        @JsonProperty("warehouseId") String warehouseId,
        @JsonProperty("hubId") String hubId,
        @JsonProperty("state") OrderState state,
        @JsonProperty("goodsValue") Money goodsValue,
        @JsonProperty("lineItems") List<LineItem> lineItems,
        @JsonProperty("promotions") OrderPromotion promotions,
        @JsonProperty("destination") ShippingContact destination,
        @JsonProperty("dropshipper") DropShipper dropShipper,
        @JsonProperty("shipping") ShippingData shipping,
        @JsonProperty("payment") PaymentData payment,
        @JsonProperty("timeStampHistory") TimestampHistory timeStampHistory,
        @JsonProperty("orderDate") Instant orderDate,
        @JsonProperty("buyerAdminFee") OrderBuyerAdminFee buyerAdminFee,
        @JsonProperty("OrderSellerAdminFee") OrderSellerAdminFee sellerAdminFee,
        @JsonProperty("loyaltyUsage") Long loyaltyUsage,
        @JsonProperty("autoConfirm") Boolean autoAccept,
        @JsonProperty("deliveryMethod") DeliveryMethod deliveryMethod,
        @JsonProperty("sla") Instant sla
) {
}
