package asia.powerbiz.utils.models.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class AppErrorException extends RuntimeException{
    private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;

}