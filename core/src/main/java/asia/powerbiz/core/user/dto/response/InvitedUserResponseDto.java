package asia.powerbiz.core.user.dto.response;


import asia.powerbiz.core.user.constants.WorkspaceRoleType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@JsonIgnoreProperties
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InvitedUserResponseDto {
    private String requestId;
    private String message;
    private Payload data;

    @Data
    @JsonIgnoreProperties
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Payload{
        private String username;
        private String name;
        private String email;
        private String phoneNumber;
        private String workspaceRoleId;
        private List<String> businessId;
        private List<String> restrictionList;
        private WorkspaceRoleType workspaceRoleType;
    }

}
