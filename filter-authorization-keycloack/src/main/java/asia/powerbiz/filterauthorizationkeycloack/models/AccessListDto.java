package asia.powerbiz.filterauthorizationkeycloack.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AccessListDto {
    private String restrictionLevel;
    private String restrictionBase;
    private List<String> businessId;
    private List<String> restrictionList;
    private List<String> accessType;
}
