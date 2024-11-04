package asia.powerbiz.core.warehouse.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateWarehouseResponseDto {
    private Payload data;
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Payload {
        private UUID id;
    }
}
