package asia.powerbiz.core.business.entity;

import asia.powerbiz.core.business.dto.vo.MenuAccessDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class MenuSetAccessEntity implements Serializable {
    private String menuAccessId;
    private List<MenuAccessDto> menuAccessList;
}
