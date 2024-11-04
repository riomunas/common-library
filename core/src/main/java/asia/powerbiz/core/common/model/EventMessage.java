package asia.powerbiz.core.common.model;

import asia.powerbiz.core.utils.DateTimeFormatUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Accessors(chain = true)
public class EventMessage<D> implements Serializable {
    protected String eventId;
    protected String eventType;
    protected Instant timestamp;
    @JsonProperty("createdBy")
    protected String requestedBy;
    protected String eventReferenceId;
    protected String requestId;
    protected D data;

    public EventMessage() {
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = DateTimeFormatUtil.getInstantNow();
    }

    public EventMessage(final D data) {
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = DateTimeFormatUtil.getInstantNow();
        this.data = data;
    }
    public EventMessage(String eventId, final D data) {
        this.eventId = eventId;
        this.timestamp = DateTimeFormatUtil.getInstantNow();
        this.data = data;
    }

    public EventMessage(final D data, UUID eventReferenceId) {
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = DateTimeFormatUtil.getInstantNow();
        this.eventReferenceId = eventReferenceId.toString();
        this.data = data;
    }

    public EventMessage(final D data, String eventReferenceId) {
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = DateTimeFormatUtil.getInstantNow();
        this.eventReferenceId = eventReferenceId;
        this.data = data;
    }

    public String getEventType() {
        if (eventType != null)
            return eventType;

        var camelCaseEventType = toCamelCase(getClass().getSimpleName());
        return StringUtils.delete(camelCaseEventType, "Event");
    }

    @JsonIgnore
    public String getEventHandler() {
        return StringUtils.capitalize(this.eventType);
    }

    @JsonIgnore
    public String getBeanEventHandlerName() {
        return String.format("%sEventHandler", this.getEventHandler());
    }

    protected String toCamelCase(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }
}
