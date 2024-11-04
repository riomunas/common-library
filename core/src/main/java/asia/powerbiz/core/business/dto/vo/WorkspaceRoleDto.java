package asia.powerbiz.core.business.dto.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WorkspaceRoleDto {
    private String workspaceRoleId;
    private String roleId;
    private String moduleAccessId;
    private String mainMenuSetId;
    private String settingMenuSetId;
    private String channelMenuSetId;

}
