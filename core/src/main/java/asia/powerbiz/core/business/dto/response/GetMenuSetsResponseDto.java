package asia.powerbiz.core.business.dto.response;

import asia.powerbiz.core.business.dto.vo.MenuAccessDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
public class GetMenuSetsResponseDto {
    private String requestId;
    private String status;
    private Payload data;

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @AllArgsConstructor
    public static class Payload {
        private String menuKey;
        private String viewbase;
        private String viewlevel;
        private List<MenuAccessDto> menus;
    }

    public GetMenuSetsResponseDto(String requestId, String menuKey, String viewbase, String viewlevel, List<MenuAccessDto> menus){
        this.requestId = requestId;
        this.status = "OK";
        this.data = new Payload(menuKey, viewbase, viewlevel, menus);
    }

}
