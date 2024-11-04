package asia.powerbiz.core.salesorder.models.data;

import asia.powerbiz.core.common.vo.Channel;
import asia.powerbiz.core.common.vo.ShippingData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderShippingChangedEventData(
        UUID id,
        String businessId,
        ShippingData shipping,
        Channel channel,
        Instant sla
) {
}
