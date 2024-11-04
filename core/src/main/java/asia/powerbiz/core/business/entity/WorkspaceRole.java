package asia.powerbiz.core.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceRole implements Serializable {
    @Serial
    private static final long serialVersionUID= 2613433134968031069L;

    private String id;
    private String workspaceId;
    private String name;
    private String description;
    private String roleId;
    private UUID moduleAccessId;
    private UUID mainMenuSetId;
    private String settingMenuSetId;
    private String channelMenuSetId;
}