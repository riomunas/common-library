package asia.powerbiz.core.user.models.data;

import asia.powerbiz.core.user.vo.Otp;

public record UserRegisterRequestedEventData(
        String userId,
        Otp otp,
        String referenceCode
) {
}
