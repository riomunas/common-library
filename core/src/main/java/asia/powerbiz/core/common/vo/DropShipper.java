package asia.powerbiz.core.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DropShipper {

    private String firstName;
    private String lastName;
    private String name;
    private String phone;

    public DropShipper(String name, String phone){
        this.name = name;
        this.phone = phone;
    }
}
