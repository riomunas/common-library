package asia.powerbiz.core.common.constant;

import asia.powerbiz.core.shipping.models.ShippingDeliveredEvent;

public interface EventHandlerName {
    String USER_REGISTER_REQUESTED_EVENT = "UserRegisterRequestedEventHandler";
    String NEW_OTP_REQUESTED_EVENT = "NewOtpRequestedEventHandler";
    String REGISTER_REQUEST_ACCEPTED_EVENT = "RegisterRequestAcceptedEventHandler";
    String USER_CREATED_EVENT = "UserCreatedEventHandler";
    String SIMPLE_WORKSPACE_CREATED_EVENT = "SimpleWorkspaceCreatedEventHandler";
    String USER_WORKSPACE_ASSIGNED_EVENT = "UserWorkspaceAssignedEventHandler";
    String WORKSPACE_USER_INVITED_EVENT = "WorkspaceUserInvitedEventHandler";


    String CREATE_ORDER_EVENT = "CreateOrderEventHandler";

    // OrderEventHandler
    String ORDER_CREATED_AND_VERIFIED_EVENT = "OrderCreatedAndVerifiedEventHandler";
    String ORDER_CREATED_AND_SUBMITTED_EVENT = "OrderCreatedAndSubmittedEventHandler";
    String ORDER_CREATED_AND_ACCEPTED_EVENT = "OrderCreatedAndAcceptedEventHandler";
    String ORDER_CREATED_AND_COMPLETED_EVENT = "OrderCreatedAndCompletedEventHandler";
    String ORDER_CREATED_AND_CANCELED_EVENT = "OrderCreatedAndCanceledEventHandler";
    String ORDER_CREATED_AND_CANCEL_REQUESTED_EVENT = "OrderCreatedAndCancelRequestedEventHandler";
    String ORDER_BOOKING_STATE_UPDATED_EVENT = "OrderBookingStateUpdatedEventHandler";
    String ORDER_SUBMITTED_EVENT =  "OrderSubmittedEventHandler";
    String ORDER_ACCEPTED_EVENT =  "OrderAcceptedEventHandler";
    String ORDER_SUBMITTED_AND_ACCEPTED_EVENT = "OrderSubmittedAndAcceptedEventHandler";
    String CHANNEL_ORDER_ACCEPTED_EVENT =  "ChannelOrderAcceptedEventHandler";
    String ORDER_COMPLETED_EVENT = "OrderCompletedEventHandler";
    String ORDER_CANCELED_EVENT = "OrderCanceledEventHandler";
    String ORDER_CANCEL_REQUESTED_EVENT = "OrderCancelRequestedEventHandler";
    String CANCEL_REQUEST_REJECTED_EVENT =  "CancelRequestRejectedEventHandler";
    String ORDER_SHIPPING_CHANGED_EVENT = "OrderShippingChangedEventHandler";
    String STORAGE_SHIPPING_LABEL_UPDATED_EVENT = "StorageShippingLabelUpdatedEventHandler";
    String ORDER_SHIPPING_ATTRIBUTE_UPDATED_EVENT = "OrderShippingAttributeUpdatedEventHandler";


    //
    String CONFIRM_ORDER_REQUEST_EVENT = "ConfirmOrderRequestEventHandler";

    // SHIPPING --
    String SHIPPING_BUYER_ACCEPTED_EVENT = "ShippingBuyerAcceptedEventHandler";
    String SHIPPING_SHIPPED_EVENT = "ShippingShippedEventHandler";
    String SHIPPING_DELIVERED_EVENT = "ShippingDeliveredEventHandler";
    String AWB_CREATED_EVENT = "AwbCreatedEventHandler";


    // Shopee webhook


    // --- Shopee
    String SHOPEE_MAIN_ORDER_CREATED_EVENT = "ShopeeMainOrderCreatedEventHandler";
    String ORDER_NOTIFICATION_RECEIVED_EVENT = "OrderNotificationReceivedEventHandler";
    String ORDER_TRACKING_NUMBER_UPDATED_EVENT = "OrderTrackingNumberUpdatedEventHandler";
    String GET_TRACKING_NUMBER_REQUEST_EVENT = "GetTrackingNumberRequestEventHandler";
    String SHIPPING_DOCUMENT_STATUS_READIED_EVENT = "ShippingDocumentStatusReadiedEventHandler";
    String CANCEL_ORDER_REQUESTED_EVENT = "CancelOrderRequestedEventHandler";
    String REJECT_CANCEL_FROM_BUYER_REQUEST_EVENT = "RejectCancelFromBuyerRequestEventHandler";
    String START_SYNCHRONIZE_ORDER_EVENT = "StartSynchronizeOrderEventHandler";
    String SYNC_SINGLE_ORDER_REQUEST_EVENT = "SyncSingleOrderRequestEventHandler";
    String SHIPPING_DOCUMENT_STATUS_UPDATED_EVENT = "ShippingDocumentStatusUpdatedEventHandler";
    String DOWNLOAD_INSTANT_COURIER_SHIPPING_LABEL_REQUEST_EVENT = "DownloadInstantCourierShippingLabelRequestEventHandler";

    // Fulfillment
    String FULFILLMENT_CREATED_EVENT = "FulfillmentCreatedEventHandler";
    String FULFILLMENT_CREATED_AND_ACCEPTED_EVENT = "FulfillmentCreatedAndAcceptedEventHandler";
    String FULFILLMENT_PICK_CONFIRMED_EVENT = "FulfillmentPickConfirmedEventHandler";
    String FULFILLMENT_PACKING_COMPLETED_EVENT = "FulfillmentPackingCompletedEventHandler";
    String FULFILLMENT_GOOD_ISSUED_EVENT = "FulfillmentGoodIssuedEventHandler";
}
