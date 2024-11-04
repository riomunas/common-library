package asia.powerbiz.core.channel.shopee.dto.response.order;

import asia.powerbiz.core.channel.shopee.constant.SynchronizeStatus;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SynchronizeStatusResponseDto {
    private SynchronizeStatus status;
    private List<String> processIds;

}
