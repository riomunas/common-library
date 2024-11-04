package asia.powerbiz.core.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private String line1;
    private String line2;
    private String subDistrict;
    private String district;
    private String city;
    private String province;
    private String country;
    private String postalCode;
    private Double latitude;
    private Double longitude;
    private String countryCode;
    private String note;

    public Address(String line1, String country, String province, String city, String district, String subDistrict, String postalCode){
        this.line1 = line1;
        this.country = country;
        this.province = province;
        this.city = city;
        this.district = district;
        this.subDistrict = subDistrict;
        this.postalCode = postalCode;
    }
}
