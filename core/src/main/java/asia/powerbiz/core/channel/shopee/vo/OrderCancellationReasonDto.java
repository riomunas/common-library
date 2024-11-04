package asia.powerbiz.core.channel.shopee.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderCancellationReasonDto {
    private UUID id;
    private String code;
    private String description;
    private Boolean isDefaultCancelRequested;
}
