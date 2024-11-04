package asia.powerbiz.core.channel.shopee.model.data;

public record ShippingDocumentStatusUpdatedEventData(
        String orderSn,
        String packageNumber,
        String status,
        Long shopId

) {
}
