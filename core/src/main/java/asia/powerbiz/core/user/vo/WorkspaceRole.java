package asia.powerbiz.core.user.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WorkspaceRole {
    private String id;
    private Role role;
    private String restrictionLevel;
    private String restrictionBase;
    private Boolean isDefault;
    private Integer accessType;

    // future improvement base on channel
    private Boolean channelRestricted = false;
    private List<Long> channelIdList = new ArrayList<>();

}