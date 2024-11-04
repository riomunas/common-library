package asia.powerbiz.utils.models.error;

import java.time.Instant;

public record ApiErrorResponse(
        String requestId,
        String errorCode,
        String message,
        Integer statusCode,
        String statusName,
        String path,
        String method,
        Instant timestamp
) {
}
