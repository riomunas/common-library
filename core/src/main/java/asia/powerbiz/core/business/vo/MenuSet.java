package asia.powerbiz.core.business.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class MenuSet {
    private UUID menuId;
    private String title;
    private String type;
    private String key;
    private String lang;
    private String icon;
    private String url;
    private List<String> access;
    private UUID parentId;

}
