package asia.powerbiz.core.deliveryorder.constant;

public enum FulfillmentState {
    CREATED,
    CONFIRMED,
    ACCEPTED,
    ON_PICKING,
    ON_PACKING,
    PACKING_COMPLETED,
    PICK_CONFIRMED,
    GOOD_ISSUED,
    GOOD_ISSUED_CANCELED,
    @Deprecated
    DELIVERED,
    CANCEL_REQUESTED,
    CANCEL_PENDING,
    CANCELED,
}
