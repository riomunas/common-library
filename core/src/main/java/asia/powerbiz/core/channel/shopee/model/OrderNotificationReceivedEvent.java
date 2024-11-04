package asia.powerbiz.core.channel.shopee.model;

import asia.powerbiz.core.channel.shopee.model.data.OrderNotificationReceivedEventData;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.axonframework.serialization.Revision;

import java.time.Instant;
import java.util.UUID;

@Revision("1.0")
public record OrderNotificationReceivedEvent(
        @JsonProperty("eventId") UUID eventId,
        @JsonProperty("eventType") String eventType,
        @JsonProperty("eventHandler") String eventHandler,
        @JsonProperty("eventReferenceId") String eventReferenceId,
        @JsonProperty("requestId") String requestId,
        @JsonProperty("timestamp") Instant timestamp,
        @JsonProperty("createdBy") String requestedBy,
        @JsonProperty("data")OrderNotificationReceivedEventData data
        ) {
}
