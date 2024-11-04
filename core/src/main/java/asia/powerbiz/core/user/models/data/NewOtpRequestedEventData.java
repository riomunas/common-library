package asia.powerbiz.core.user.models.data;

import asia.powerbiz.core.user.vo.Otp;

public record NewOtpRequestedEventData(
        String userId,
        Otp otp
) {
}
