package asia.powerbiz.core.user.models.data;

import java.time.OffsetDateTime;

public record RegisterRequestAcceptedEventData(
        String userId,
        String registrationCode,
        OffsetDateTime expiredTime
) {
}
