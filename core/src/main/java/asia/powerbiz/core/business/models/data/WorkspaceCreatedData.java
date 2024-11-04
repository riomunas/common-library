package asia.powerbiz.core.business.models.data;

import java.time.OffsetDateTime;

public record WorkspaceCreatedData(
        String id,
        String name,
        OffsetDateTime createdAt,
        String workspaceType,
        String ownerUserId,
        String ownerUserEmail
) {
}
