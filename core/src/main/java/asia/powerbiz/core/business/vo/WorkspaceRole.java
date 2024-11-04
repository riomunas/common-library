package asia.powerbiz.core.business.vo;

import asia.powerbiz.core.business.contants.RestrictionBase;
import asia.powerbiz.core.business.contants.RestrictionLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class WorkspaceRole {
    private String workspaceRoleId;
    private String roleName;
    private String roleDescription;
    private RestrictionLevel restrictionLevel;
    private RestrictionBase restrictionBase;
    private String moduleAccessId;
    private String mainMenuSetId;
    private String settingMenuSetId;
    private String channelMenuSetId;

}
