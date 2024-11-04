package asia.powerbiz.core.common.vo;

import asia.powerbiz.core.salesorder.constant.OrderState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.Instant;
import java.util.Objects;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimestampHistory {
    private Instant created;
    private Instant verified;
    private Instant submitted;
    private Instant autoCancel;
    private Instant accepted;
    private Instant channelAccepted;
    private Instant completed;
    private Instant canceled;
    private Instant rejected;
    private Instant cancelRequested;

    public TimestampHistory setIfEmpty(OrderState state, Instant value) {
        if (state.equals(OrderState.CREATED) && this.created == null) {
            this.created = value;
        } else if (state.equals(OrderState.VERIFIED) && this.verified == null) {
            if(Objects.isNull(created)) {
                created = value;
            }
            this.verified = value;
        } else if (state.equals(OrderState.SUBMITTED) && this.submitted == null) {
            if(Objects.isNull(created)) {
                created = value;
            }
            if(Objects.isNull(verified)) {
                verified = value;
            }
            submitted = value;
        } else if (state.equals(OrderState.ACCEPTED) && accepted == null) {
            if(Objects.isNull(created)) {
                created = value;
            }
            if(Objects.isNull(verified)) {
                verified = value;
            }
            if(Objects.isNull(submitted)) {
                submitted = value;
            }
            accepted = value;
        } else if (state.equals(OrderState.COMPLETED) && completed == null) {
            if(Objects.isNull(created)) {
                created = value;
            }
            if(Objects.isNull(verified)) {
                verified = value;
            }
            if(Objects.isNull(submitted)) {
                submitted = value;
            }
            if(Objects.isNull(accepted)) {
                accepted = value;
            }
            completed = value;
        } else if (state.equals(OrderState.CANCELED) && canceled == null) {
            if(Objects.isNull(created)) {
                created = value;
            }
            if(Objects.isNull(verified)) {
                verified = value;
            }
            if(Objects.isNull(submitted)) {
                submitted = value;
            }
            if(Objects.isNull(accepted)) {
                accepted = value;
            }
            canceled = value;
        } else if (state.equals(OrderState.REJECTED) && rejected == null) {
            rejected = value;
        } else if (state.equals(OrderState.CANCELREQUESTED) && cancelRequested == null) {
            if(Objects.isNull(created)) {
                created = value;
            }
            if(Objects.isNull(verified)) {
                verified = value;
            }
            if(Objects.isNull(submitted)) {
                submitted = value;
            }
            if(Objects.isNull(accepted)) {
                accepted = value;
            }
            cancelRequested = value;
        }

        return this;
    }
}
