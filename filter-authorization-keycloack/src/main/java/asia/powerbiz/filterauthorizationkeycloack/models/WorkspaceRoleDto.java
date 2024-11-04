package asia.powerbiz.filterauthorizationkeycloack.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WorkspaceRoleDto {
    private String workspaceId;
    private String workspaceName;
    private String roleId;
    private String roleName;
    private String restrictionLevel;
    private String restrictionBase;
    private List<String> businessId;
    private List<String> restrictionList;
    private String moduleAccessId;
    private String mainMenuSetId;
    private String settingMenuSetId;
    private String channelMenuSetId;
    @Deprecated
    private List<ModuleAccessDto> moduleAccesses;

}
