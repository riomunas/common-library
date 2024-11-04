package asia.powerbiz.core.warehouse.dto.request;

import asia.powerbiz.core.warehouse.dto.vo.AddressDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateWarehouseRequestDto {
    UUID id;
    private String code;
    // @NotBlank
    private String name;
    private String businessId;
    // @NotBlank
    private String contactName;
    // @NotBlank
    private String contactPhone;
    //@Valid
    private AddressDto address;
    private String extCode;
    private String wmsCode;
    private String wmsCategories;
    private String param1;
    private String param2;
    private String param3;

}
