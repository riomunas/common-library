package asia.powerbiz.core.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Customer {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String lastName;
    private String firstName;

    public Customer(String id, String firstName, String lastName, String phone){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.name = Objects.nonNull(firstName) ?
                            Objects.nonNull(lastName) ?
                                firstName.concat(" ").concat(lastName.trim()) :
                                    firstName
                            :
                Objects.nonNull(lastName) ? lastName : null;
    }

}
