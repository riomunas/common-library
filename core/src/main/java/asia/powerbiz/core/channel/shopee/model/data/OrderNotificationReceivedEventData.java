package asia.powerbiz.core.channel.shopee.model.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderNotificationReceivedEventData implements Serializable {
    private Integer type;
    private Long shopId;
    private String orderSn;
    private String status;
    private String completedScenario;
    private Long updateTime;
    private Long timestamp;

    public OrderNotificationReceivedEventData(Long shopId, String orderSn, String status){
        this.shopId = shopId;
        this.orderSn = orderSn;
        this.status = status;
        this.timestamp = OffsetDateTime.now().toEpochSecond()*1000;
        this.updateTime = OffsetDateTime.now().toEpochSecond()*1000;
    }
}
