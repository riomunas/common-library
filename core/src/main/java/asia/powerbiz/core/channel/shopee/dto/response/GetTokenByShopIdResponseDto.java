package asia.powerbiz.core.channel.shopee.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetTokenByShopIdResponseDto {
    private List<Payload> data;


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Payload{
        private String businessId;
        private String warehouseId;
        private Long channelId;
        private SalesChannel salesChannel;
        private TokenCredential credential;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class TokenCredential{
        private Long shopId;
        private String clientId;
        private String clientSecret;
        private String accessToken;
        private OffsetDateTime expiredAt;
    }

    @Data
    @Accessors(chain = true)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class SalesChannel {
        private Integer id;
        private String code;
    }

}
