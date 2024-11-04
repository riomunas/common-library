package asia.powerbiz.core.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceDto {

    private String id;
    private String name;
    private String workspaceType;
    private String ownerUserId;
    private String ownerUserEmail;
    private OffsetDateTime createdAt;
}
