package asia.powerbiz.filterauthorizationkeycloack;

import asia.powerbiz.filterauthorizationkeycloack.entities.redis.UserWorkspaceAccess;
import asia.powerbiz.filterauthorizationkeycloack.repositories.redis.WorkspaceRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Component
public class WebFilterKeycloak{
    private final WorkspaceRepository workspaceRepository;
    private final String moduleId;

    public WebFilterKeycloak(WorkspaceRepository workspaceRepository,
                             @Value("${app.module-id}") String moduleId){
        this.moduleId = moduleId;
        this.workspaceRepository = workspaceRepository;
    }

    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        String[] ignoresPath = new String[]{
                "swagger", "actuator", "api-docs", "/internal", "swagger-ui", "/me"
        };

        for (String pathToIgnore : ignoresPath) {
            if (request.getURI().getPath().contains(pathToIgnore)) {
                return chain.filter(exchange);
            }
        }

        List<String> authorization = request.getHeaders().get("Authorization");
        if (authorization == null || !authorization.get(0).startsWith("Bearer")) {
            log.warn("WebFilterKeycloak: No Authorization");
            response.setStatusCode(HttpStatus.FORBIDDEN);
            return chain.filter(exchange);
        }

        try {
            String tokenHeader = authorization.get(0);
            String token = tokenHeader.substring(7);
            DecodedJWT decodedJWT = JWT.decode(token);
            var userId = decodedJWT.getSubject();
            List<String> workspaceHeader = request.getHeaders().get("Workspace-Id");

            if (Objects.isNull(userId) || Objects.isNull(workspaceHeader)) {
                response.setStatusCode(HttpStatus.FORBIDDEN);
                return chain.filter(exchange);
            }
            var workspaceId = workspaceHeader.get(0);

            Optional<UserWorkspaceAccess> workspaceOpt = workspaceRepository.findById(userId);
            if (Objects.isNull(workspaceOpt) || workspaceOpt.isEmpty()) {
                log.warn("WebFilterKeycloak: User workspace redis not found");
                response.setStatusCode(HttpStatus.FORBIDDEN);
                return chain.filter(exchange);
            }
            UserWorkspaceAccess workspace = workspaceOpt.get();
            var userWrkspcResult = workspace.getUserWorkspaces().stream().filter(userWrkspc -> userWrkspc.getWorkspaceId().equalsIgnoreCase(workspaceId))
                    .findFirst();
            if (userWrkspcResult.isEmpty() ||
                    userWrkspcResult.get().getModuleAccesses().stream().noneMatch(moduleAccess -> moduleAccess.getModuleId().equalsIgnoreCase(moduleId))) {
                response.setStatusCode(HttpStatus.FORBIDDEN);
                log.warn("WebFilterKeycloak: User workspace module access is empty");
                return chain.filter(exchange);
            }

            request.mutate().header("User-Id", userId);
            String userName = decodedJWT.getClaim("name").asString();
            request.mutate().header("User-Name", userName);

            var userWorkspace = userWrkspcResult.get();
            var moduleAccess = userWorkspace.getModuleAccesses().stream().filter(moduleAcc -> moduleAcc.getModuleId().equalsIgnoreCase(moduleId)).findFirst().get();
            request.mutate().header("Restriction-Level", userWorkspace.getRestrictionLevel());
            request.mutate().header("Restriction-Base", userWorkspace.getRestrictionBase());

            StringBuilder businessIdValue = new StringBuilder();
            for (var restriction : userWorkspace.getBusinessId()) {
                if (!businessIdValue.isEmpty()) {
                    businessIdValue.append(",").append(restriction);
                } else {
                    businessIdValue.append(restriction);
                }
            }
            request.mutate().header("Business-Id_", businessIdValue.toString());

            StringBuilder restrictionListValue = new StringBuilder();
            for (var restriction : userWorkspace.getRestrictionList()) {
                if (!restrictionListValue.isEmpty()) {
                    restrictionListValue.append(",").append(restriction);
                } else {
                    restrictionListValue.append(restriction);
                }
            }
            request.mutate().header("Restriction-List", restrictionListValue.toString());

            StringBuilder accessTypeListValue = new StringBuilder();
            for (var accessType : moduleAccess.getAccessType()) {
                if (!accessTypeListValue.isEmpty()) {
                    accessTypeListValue.append(",").append(accessType);
                } else {
                    accessTypeListValue.append(accessType);
                }
            }
            request.mutate().header("Access-Type", accessTypeListValue.toString());

            if (Objects.isNull(request.getHeaders().get("Restriction-List")) ||
                    Objects.isNull(request.getHeaders().get("Restriction-Level")) ||
                    Objects.isNull(request.getHeaders().get("Restriction-Base"))) {
                log.warn("WebFilterKeycloak: One of these restriction: Restriction-List, Restriction-Level, Restriction-Base is empty");
                response.setStatusCode(HttpStatus.FORBIDDEN);
                return chain.filter(exchange);
            }

            return chain.filter(exchange);
        } catch (Exception e){
            return chain.filter(exchange);
        }
    }
}
