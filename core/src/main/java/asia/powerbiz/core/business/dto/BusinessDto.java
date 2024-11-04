package asia.powerbiz.core.business.dto;

import asia.powerbiz.core.business.contants.BusinessState;
import asia.powerbiz.core.business.contants.BusinessType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessDto {

    private String businessId;
    private String businessName;
    private String businessTitle;
    private String platformId;
    // private PlatformDto platform;
    private String workspaceId;
    private WorkspaceDto workspace;
    private String categoryId;
   // private CategoryDto category;
    private List<String> currencies;
    private String imageUrl;
    private String imageBase64;
    private BusinessState businessState;
    private BusinessType businessType;
  //  private List<BusinessContactsDto> businessContacts;
  //  private CompaniesDto company;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private OffsetDateTime deletedAt;
}