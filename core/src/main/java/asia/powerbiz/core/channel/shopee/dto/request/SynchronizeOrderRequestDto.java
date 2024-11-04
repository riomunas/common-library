package asia.powerbiz.core.channel.shopee.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.annotation.Nullable;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SynchronizeOrderRequestDto {
    @Nullable
    private OffsetDateTime start;

    @Nullable
    private OffsetDateTime end;

    @Nullable
    private List<String> orderIds;

    @Nullable
    private Boolean force;

    public Boolean shouldRecordHistory() {
        return Objects.isNull(orderIds) || orderIds.isEmpty();
    }

}
