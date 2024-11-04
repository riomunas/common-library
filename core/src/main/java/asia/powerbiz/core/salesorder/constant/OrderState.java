package asia.powerbiz.core.salesorder.constant;

public enum OrderState {
    CREATED,
    VERIFIED,
    SUBMITTED,
    ACCEPTED,
    CONFIRMED,
    PICK_CONFIRMED,
    PACKING_COMPLETED,
    GOOD_ISSUED,
    @Deprecated
    DELIVERED,
    CANCELED,
    COMPLETED,
    REJECTED,
    CANCEL_REQUESTED,
    CANCELREQUESTED
}
