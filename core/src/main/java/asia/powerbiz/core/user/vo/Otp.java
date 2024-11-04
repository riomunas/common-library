package asia.powerbiz.core.user.vo;

import java.time.OffsetDateTime;

public record Otp(
        String value,
        OffsetDateTime expiredAt
) {
}