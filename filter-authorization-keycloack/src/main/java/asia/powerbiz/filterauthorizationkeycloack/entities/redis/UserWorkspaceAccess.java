package asia.powerbiz.filterauthorizationkeycloack.entities.redis;

import asia.powerbiz.filterauthorizationkeycloack.models.WorkspaceRoleDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserWorkspaceAccess implements Serializable {
    private String userId;
    private List<WorkspaceRoleDto> userWorkspaces;
}
