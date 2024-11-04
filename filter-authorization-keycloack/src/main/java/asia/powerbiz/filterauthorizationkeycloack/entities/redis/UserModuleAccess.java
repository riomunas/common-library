package asia.powerbiz.filterauthorizationkeycloack.entities.redis;

import asia.powerbiz.filterauthorizationkeycloack.models.ModuleAccessDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserModuleAccess {
    private String moduleAccessId;
    private List<ModuleAccessDto> moduleAccessList;
}
