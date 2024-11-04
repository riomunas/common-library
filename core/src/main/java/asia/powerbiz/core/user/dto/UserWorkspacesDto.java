package asia.powerbiz.core.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserWorkspacesDto {
    private Long id;
    private WorkspaceRoleDto workspaceRole;
    private Boolean isDefault;
    private List<String> businessId;;
    private List<String> restrictionList;;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}