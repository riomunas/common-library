package asia.powerbiz.core.user.dto;

import asia.powerbiz.core.user.constants.UserState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private UUID id;
    private String username;
    private String fullName;
    private String email;
    private OffsetDateTime emailVerifiedAt;
    private String phoneNumber;
    private OffsetDateTime phoneNumberVerifiedAt;
    private UserState status;
    private List<UserWorkspacesDto> userWorkspaces;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

}