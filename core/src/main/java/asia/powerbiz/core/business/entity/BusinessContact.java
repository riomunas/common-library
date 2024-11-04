package asia.powerbiz.core.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessContact {
    private String name;
    private String position;
    private String phoneNumber;
    private String email;
}
