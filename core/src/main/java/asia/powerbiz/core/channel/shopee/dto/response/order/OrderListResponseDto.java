package asia.powerbiz.core.channel.shopee.dto.response.order;

import asia.powerbiz.core.channel.shopee.vo.ShortOrderView;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderListResponseDto {
    private String requestId;
    private Integer page;
    private Integer limit;
    private Long totalRecord;
    private List<ShortOrderView> data;
}
