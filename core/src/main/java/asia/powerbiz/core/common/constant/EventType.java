package asia.powerbiz.core.common.constant;

public interface EventType {
    String USER_REGISTER_REQUESTED_EVENT = "userRegisterRequestedEvent";
    String NEW_OTP_REQUESTED_EVENT = "newOtpRequestedEvent";
    String REGISTER_REQUEST_ACCEPTED_EVENT = "registerRequestAcceptedEvent";
    String USER_CREATED_EVENT = "userCreatedEvent";
    String SIMPLE_WORKSPACE_CREATED_EVENT = "simpleWorkspaceCreatedEvent";
    String USER_WORKSPACE_ASSIGNED_EVENT = "userWorkspaceAssignedEvent";
    String WORKSPACE_USER_INVITED_EVENT = "workspaceUserInvitedEvent";



    // Inventory Event
    String SALES_ORDER_ITEMS_BOOKED_EVENT = "salesOrderItemsBooked";


    // OrderEvents
    String ORDER_CREATED_AND_VERIFIED_EVENT = "orderCreatedAndVerified";
    String ORDER_CREATED_AND_SUBMITTED_EVENT = "orderCreatedAndSubmitted";
    String ORDER_CREATED_AND_ACCEPTED_EVENT = "orderCreatedAndAccepted";
    String ORDER_CREATED_AND_COMPLETED_EVENT = "orderCreatedAndCompleted";
    String ORDER_CREATED_AND_CANCELED_EVENT = "orderCreatedAndCanceled";
    String ORDER_CREATED_AND_CANCEL_REQUESTED_EVENT = "orderCreatedAndCancelRequested";
    String ORDER_BOOKING_STATE_UPDATED_EVENT = "orderBookingStateUpdated";
    String ORDER_SUBMITTED_EVENT =  "orderSubmitted";
    String ORDER_ACCEPTED_EVENT =  "orderAccepted";
    String ORDER_SUBMITTED_AND_ACCEPTED_EVENT = "orderSubmittedAndAccepted";
    String CHANNEL_ORDER_ACCEPTED_EVENT =  "channelOrderAccepted";
    String ORDER_COMPLETED_EVENT = "orderCompleted";
    String ORDER_CANCELED_EVENT = "orderCanceled";
    String ORDER_CANCEL_REQUESTED_EVENT = "orderCancelRequested";

    String CANCEL_REQUEST_REJECTED_EVENT =  "cancelRequestRejected";


    // Shipping
    String SHIPPING_BUYER_ACCEPTED_EVENT = "shippingBuyerAcceptedEvent";
    String SHIPPING_SHIPPED_EVENT = "shippingShipped";
    String SHIPPING_DELIVERED_EVENT = "shippingDelivered";
    String AWB_CREATED_EVENT = "awbCreated";


    // --  shopee
    String CREATE_ORDER_EVENT = "createOrder";
    String ORDER_NOTIFICATION_RECEIVED_EVENT = "orderNotificationReceived";
    String SHOPEE_MAIN_ORDER_CREATED_EVENT = "shopeeMainOrderCreated";
    String CONFIRM_ORDER_REQUEST_EVENT = "confirmOrderRequest";
    String ORDER_TRACKING_NUMBER_UPDATED_EVENT = "orderTrackingNumberUpdated";
    String GET_TRACKING_NUMBER_REQUEST_EVENT = "getTrackingNumberRequest";
    String SHIPPING_DOCUMENT_STATUS_READIED_EVENT = "shippingDocumentStatusReadied";
    String CANCEL_ORDER_REQUESTED_EVENT = "cancelOrderRequested";
    String REJECT_CANCEL_FROM_BUYER_REQUEST_EVENT = "rejectCancelFromBuyerRequest";
    String START_SYNCHRONIZE_ORDER_EVENT = "startSynchronizeOrder";
    String SYNC_SINGLE_ORDER_REQUEST_EVENT = "syncSingleOrderRequest";
    String SHIPPING_DOCUMENT_STATUS_UPDATED_EVENT = "shippingDocumentStatusUpdated";
    String DOWNLOAD_INSTANT_COURIER_SHIPPING_LABEL_REQUEST_EVENT = "downloadInstantCourierShippingLabelRequest";
    String ORDER_SHIPPING_CHANGED_EVENT = "orderShippingChanged";
    String STORAGE_SHIPPING_LABEL_UPDATED_EVENT = "storageShippingLabelUpdated";
    String ORDER_SHIPPING_ATTRIBUTE_UPDATED_EVENT = "orderShippingAttributeUpdated";


    // Delivery order
    String FULFILLMENT_CREATED_EVENT = "fulfillmentCreated";
    String FULFILLMENT_CREATED_AND_ACCEPTED_EVENT = "fulfillmentCreatedAndAccepted";
    String FULFILLMENT_PICK_CONFIRMED_EVENT = "fulfillmentPickConfirmed";
    String FULFILLMENT_PACKING_COMPLETED_EVENT = "fulfillmentPackingCompleted";
    String FULFILLMENT_GOOD_ISSUED_EVENT = "fulfillmentGoodIssued";


}
