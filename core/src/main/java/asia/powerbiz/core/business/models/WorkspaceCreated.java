package asia.powerbiz.core.business.models;

import asia.powerbiz.core.business.models.data.WorkspaceCreatedData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.UUID;

@Deprecated
@JsonIgnoreProperties(ignoreUnknown = true)
public record WorkspaceCreated(
        @JsonProperty("eventId") UUID eventId,
        @JsonProperty("eventType") String eventType,
        @JsonProperty("eventHandler") String eventHandler,
        @JsonProperty("eventReferenceId") String eventReferenceId,
        @JsonProperty("requestId") String requestId,
        @JsonProperty("timestamp") Instant timestamp,
        @JsonProperty("createdBy") String requestedBy,
        @JsonProperty("data")WorkspaceCreatedData data
        ) {
}
