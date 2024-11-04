package asia.powerbiz.core.business.dto.request;

import asia.powerbiz.core.business.contants.WorkspaceType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateWorkspaceRequestDto {
    private String workspaceName;
    private String businessName;
    private String ownerId;
    private String invitedUserId;
    private String ownerName;
    private String ownerEmail;
    private String ownerPhone;
    private String categoryId;
    private String currency;
    private WorkspaceType workspaceType;
}
