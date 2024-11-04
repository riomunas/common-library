package asia.powerbiz.core.channel.shopee.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShortOrderView {
    private String orderNumber;
    private String orderId;
    private String createdAt;
    private String currency;
    private String status;
    private Integer totalValue;
    private Integer subtotalValue;
}
