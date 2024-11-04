package asia.powerbiz.core.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceRoleDto {
    private UUID workspaceRoleId;
    private String workspaceId;
    private String workspaceName;
    private String restrictionLevel;
    private String restrictionBase;
    private Boolean isDefault;
    private Integer accessType;
    private RolesDto role;
    private List<ModuleAccessesDto> moduleAccesses;
}