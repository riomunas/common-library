package asia.powerbiz.core.common.vo;

import asia.powerbiz.core.deliveryorder.constant.DeliveryType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class DeliveryMethod {
    private DeliveryType deliveryType;
    private String remarks;
}