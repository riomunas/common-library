package asia.powerbiz.core.salesorder.models.data;

import asia.powerbiz.core.common.vo.TimestampHistory;
import asia.powerbiz.core.salesorder.constant.OrderState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderStateChangedEventData(
        UUID id,
        String orderNumber,
        OrderState state,
        Instant sla,
        TimestampHistory timeStampHistory
) {
}
