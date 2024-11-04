package asia.powerbiz.core.business.dto.response;

import asia.powerbiz.core.business.contants.RestrictionBase;
import asia.powerbiz.core.business.contants.RestrictionLevel;
import asia.powerbiz.core.business.dto.vo.WorkspaceRoleDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateWorkspaceResponseDto {
    private String requestId;
    private String status;
    private Payload data;

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @AllArgsConstructor
    public static class Payload{
        private String workspaceId;
        private String businessId;
        private Instant expiredAt;
        private String workspaceRoleId;
        private RestrictionLevel restrictionLevel;
        private RestrictionBase restrictionBase;
        private String moduleAccessId;
        private String mainMenuSetId;
        private String settingMenuSetId;
        private String channelMenuSetId;
    }
}
