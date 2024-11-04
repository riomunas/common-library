package asia.powerbiz.core.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingContact {
    private String name;
    private String phone;
    private Address address;
    private String note;

}
