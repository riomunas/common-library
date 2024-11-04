package asia.powerbiz.core.user.dto.vo;

import asia.powerbiz.core.business.contants.RestrictionBase;
import asia.powerbiz.core.business.contants.RestrictionLevel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WorkspaceUserDto {
    private String workspaceId;
    private String workspaceName;
    private String roleName;
    private RestrictionLevel restrictionLevel;
    private RestrictionBase restrictionBase;
    private List<String> restrictionList;
    private List<String> businessIdList;
    private Integer accessType;
    private Boolean isDefault;
}
