package asia.powerbiz.core.warehouse.dto.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String streetName;
    @NonNull
    private Long countryId;
    @NonNull
    private String countryName;
    private Long provinceId;
    private String provinceName;
    @NonNull
    private Long cityId;
    @NonNull
    private String cityName;
    private Long districtId;
    private String districtName;
    private Long subDistrictId;
    private String subDistrictName;
    @NonNull
    private String postalCode;
}
