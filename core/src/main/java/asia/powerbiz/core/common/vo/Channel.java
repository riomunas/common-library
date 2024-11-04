package asia.powerbiz.core.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Channel(
        Long id,
        String code,
        String name,
        Integer salesChannelId

) {
}
