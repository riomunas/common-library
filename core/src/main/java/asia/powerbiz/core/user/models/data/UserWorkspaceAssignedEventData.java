package asia.powerbiz.core.user.models.data;

import asia.powerbiz.core.business.contants.RestrictionBase;
import asia.powerbiz.core.business.contants.RestrictionLevel;
import asia.powerbiz.core.business.contants.WorkspaceType;

import java.util.List;

public record UserWorkspaceAssignedEventData(
        String userId,
        String workspaceId,
        String workspaceName,
        WorkspaceType workspaceType,
        String businessId,
        String businessName,
        String workspaceRoleId,
        RestrictionLevel restrictionLevel,
        RestrictionBase restrictionBase,
        List<String> businessIdList,
        List<String> restrictionList,
        String moduleId,
        String mainMenuSetId,
        String settingMenuSetId,
        String channelMenuSetId
) {
}
