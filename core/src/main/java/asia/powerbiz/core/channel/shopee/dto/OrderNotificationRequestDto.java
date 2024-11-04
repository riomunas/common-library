package asia.powerbiz.core.channel.shopee.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class OrderNotificationRequestDto implements Serializable {

    @JsonProperty("code")
    private int type;

    @JsonProperty(value = "shop_id", required = false)
    private String shopId;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("data")
    private Serializable data;

}
