package asia.powerbiz.filterauthorizationkeycloack.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ModuleAccessDto {
    private String moduleId;
    private String moduleName;
    private String description;
    private List<String> accessType;

    public ModuleAccessDto(String moduleId, String moduleName, String description, List<String> accessType){
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.description = description;
        this.accessType = new ArrayList<>();
        this.accessType.addAll(accessType);
    }
}
