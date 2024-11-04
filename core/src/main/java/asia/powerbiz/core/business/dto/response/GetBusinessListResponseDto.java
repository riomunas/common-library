package asia.powerbiz.core.business.dto.response;

import asia.powerbiz.core.business.dto.vo.SimpleBusinessDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetBusinessListResponseDto {
    private String requestId;
    private String status;
    private Payload data;

    @Data
    @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Payload{
        private String workspaceId;
        private String workspaceName;
        private List<SimpleBusinessDto> businessList;
    }
}
