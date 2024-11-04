package asia.powerbiz.core.deliveryorder.models;

import asia.powerbiz.core.deliveryorder.models.data.FulfillmentCreatedEventData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.axonframework.serialization.Revision;

import java.time.Instant;
import java.util.UUID;

@Revision("1.1")
@JsonIgnoreProperties(ignoreUnknown = true)
public record FulfillmentCreatedEvent(
        @JsonProperty("eventId") UUID eventId,
        @JsonProperty("eventType") String eventType,
        @JsonProperty("eventHandler") String eventHandler,
        @JsonProperty("eventReferenceId") String eventReferenceId,
        @JsonProperty("requestId") String requestId,
        @JsonProperty("timestamp") Instant timestamp,
        @JsonProperty("createdBy") String requestedBy,
        @JsonProperty("data")FulfillmentCreatedEventData data
        ) {
}
