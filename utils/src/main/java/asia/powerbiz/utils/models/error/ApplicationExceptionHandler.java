package asia.powerbiz.utils.models.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.UUID;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AppErrorException.class)
    public ResponseEntity<?> handleApplicationException(final AppErrorException exception, ServerHttpRequest request){
        String requestId = UUID.randomUUID().toString();
        var response = new ApiErrorResponse(
                requestId,
                exception.getErrorCode(),
                exception.getMessage(),
                exception.getHttpStatus().value(),
                exception.getHttpStatus().name(),
                request.getPath().toString(),
                request.getMethod().toString(),
                Instant.now()
        );
        return  new ResponseEntity<>(response, exception.getHttpStatus());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUnknownException(
            final Exception exception, final ServerHttpRequest request
    ) {
        exception.printStackTrace();
        var guid = UUID.randomUUID().toString();
        var response = new ApiErrorResponse(
                guid,
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                "Internal server error",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                request.getPath().toString(),
                request.getMethod().toString(),
                Instant.now()
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
