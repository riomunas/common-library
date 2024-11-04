package asia.powerbiz.core.business.dto.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MenuAccessDto {
    private UUID menuId;
    private String title;
    private String type;
    private String key;
    private String lang;
    private String icon;
    private String url;
    private List<String> access;
    private List<MenuAccessDto> children;

    public MenuAccessDto(UUID menuId, String title, String type, String key, String lang, String icon, String url, List<String> access){
        this.menuId = menuId;
        this.title = title;
        this.type = type;
        this.key = key;
        this.lang = lang;
        this.icon = icon;
        this.url = url;
        this.access = access;
        children = new ArrayList<>();
    }

}
