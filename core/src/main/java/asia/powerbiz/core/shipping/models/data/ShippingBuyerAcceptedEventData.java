package asia.powerbiz.core.shipping.models.data;

import asia.powerbiz.core.common.vo.Channel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingBuyerAcceptedEventData {
    private UUID orderId;
    private String businessId;
    private Channel channel;
    private String shippingState;
}
