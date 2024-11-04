package asia.powerbiz.core.channel.shopee.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BaseResponse<T> {
    private String requestId;
    private String status;
    private String message;
    private T data;

    public BaseResponse(String requestId, T data){
        this.requestId = requestId;
        this.status = "success";
        this.data = data;
    }

}
