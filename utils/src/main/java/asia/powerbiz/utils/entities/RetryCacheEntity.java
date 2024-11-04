package asia.powerbiz.utils.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.amqp.core.Message;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetryCacheEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -2996000422752466196L;

    private String id;
    private String eventClass;
    private Message message;
    private String errorMessage;
    private Instant timestamp;
}
