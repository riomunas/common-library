package asia.powerbiz.filterauthorizationkeycloack.utils;

import asia.powerbiz.filterauthorizationkeycloack.models.AccessListDto;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.Arrays;
import java.util.Objects;

public class UserAccessUtil {
    public static AccessListDto getAccessList(ServerHttpRequest request) {
        var restrictionList = Arrays.asList(Objects.requireNonNull(request.getHeaders().get("Restriction-List")).get(0).split(","));
        if (restrictionList.size() == 1){
            if(restrictionList.get(0).isBlank()){
                restrictionList = null;
            };
        }

        return AccessListDto.builder()
                .restrictionLevel(Objects.requireNonNull(request.getHeaders().get("Restriction-Level")).get(0))
                .restrictionBase(Objects.requireNonNull(request.getHeaders().get("Restriction-Base")).get(0))
                .restrictionList(restrictionList)
                .accessType(Arrays.asList(Objects.requireNonNull(request.getHeaders().get("Access-Type")).get(0).split(",")))
                .businessId(Arrays.asList(Objects.requireNonNull(request.getHeaders().get("Business-Id_")).get(0).split(",")))
                .build();
    }
}