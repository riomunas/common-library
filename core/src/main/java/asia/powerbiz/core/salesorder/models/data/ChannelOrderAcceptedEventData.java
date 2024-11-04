package asia.powerbiz.core.salesorder.models.data;

import asia.powerbiz.core.salesorder.constant.OrderState;

import java.time.Instant;
import java.util.UUID;

public record ChannelOrderAcceptedEventData(
        UUID id,
        OrderState state,
        String businessId,
        Instant sla

) {
}
