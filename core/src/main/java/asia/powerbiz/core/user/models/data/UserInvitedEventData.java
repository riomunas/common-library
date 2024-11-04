package asia.powerbiz.core.user.models.data;

import java.time.Instant;
import java.time.OffsetDateTime;

public record UserInvitedEventData(
        String userId,
        String workspaceId,
        String workspaceRoleId,
        String token,
        Instant expiredAt
) {
}
