package asia.powerbiz.core.business.models.data;

import asia.powerbiz.core.business.vo.WorkspaceRole;

import java.time.OffsetDateTime;
import java.util.List;

public record SimpleWorkspaceCreatedEventData(
        String workspaceId,
        String workspaceName,
        String businessId,
        String businessName,
        String ownerId,
        String invitedUserId,
        String ownerName,
        String email,
        String phoneNumber,
        List<WorkspaceRole> roleList,
        OffsetDateTime expiredTime,
        Integer dailyOrderLimit,
        Integer maxUser,
        String currency
) {
}
