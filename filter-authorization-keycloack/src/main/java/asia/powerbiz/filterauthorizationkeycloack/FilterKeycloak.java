package asia.powerbiz.filterauthorizationkeycloack;

import asia.powerbiz.filterauthorizationkeycloack.entities.redis.UserWorkspaceAccess;
import asia.powerbiz.filterauthorizationkeycloack.repositories.redis.RedisRepository;
import com.auth0.jwt.JWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.util.Objects;

public class FilterKeycloak implements Filter {
    private final RedisRepository redisRepository;
    private final String moduleId;

    public FilterKeycloak(String redishHash, RedisTemplate redisTemplate, String moduleId) {
        this.moduleId = moduleId;
        redisRepository = new RedisRepository(redishHash, redisTemplate);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String[] ignoresPath = new String[]{
                "swagger", "actuator", "api-docs", "/internal"
        };

        for (String pathToIgnore : ignoresPath) {
            if (httpRequest.getRequestURI().contains(pathToIgnore)) {
                chain.doFilter(request, response);
                return;
            }
        }

        var tokenHeader = httpRequest.getHeader("Authorization");
        if (tokenHeader == null || !tokenHeader.startsWith("Bearer")) {
            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
            return;
        }

        String token = tokenHeader.substring(7, tokenHeader.length());
        var userId = JWT.decode(token).getSubject();
        var workspaceId = httpRequest.getHeader("Workspace-Id");

        if (Objects.isNull(userId) || Objects.isNull(workspaceId)) {
            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
            return;
        }

        var workspace = new UserWorkspaceAccess();
        workspace.setUserId(userId);

        String workspaceStr = redisRepository.get(workspace);
        try {
            workspace = new ObjectMapper().readValue(workspaceStr, UserWorkspaceAccess.class);
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }

        var mutableRequest = new MutableHttpServletRequest(httpRequest);
        mutableRequest.putHeader("User-Id", userId);

        for (var userWorkspace : workspace.getUserWorkspaces()) {
            if (userWorkspace.getWorkspaceId().equalsIgnoreCase(workspaceId)) {
                for (var moduleAccess : userWorkspace.getModuleAccesses()) {
                    if (moduleAccess.getModuleId().equalsIgnoreCase(moduleId)) {
                        mutableRequest.putHeader("Restriction-Level", userWorkspace.getRestrictionLevel());
                        mutableRequest.putHeader("Restriction-Base", userWorkspace.getRestrictionBase());

                        var businessIdValue = "";
                        for (var restriction : userWorkspace.getBusinessId()) {
                            if (!businessIdValue.isEmpty()) {
                                businessIdValue = businessIdValue + "," + restriction;
                            }
                            else {
                                businessIdValue = businessIdValue + restriction;
                            }
                        }
                        mutableRequest.putHeader("Business-Id", businessIdValue);

                        var restrictionListValue = "";
                        for (var restriction : userWorkspace.getRestrictionList()) {
                            if (!restrictionListValue.isEmpty()) {
                                restrictionListValue = restrictionListValue + "," + restriction;
                            }
                            else {
                                restrictionListValue = restrictionListValue + restriction;
                            }
                        }
                        mutableRequest.putHeader("Restriction-List", restrictionListValue);

                        var accessTypeListValue = "";
                        for (var accessType : moduleAccess.getAccessType()) {
                            if (!accessTypeListValue.isEmpty()) {
                                accessTypeListValue = accessTypeListValue + "," + accessType;
                            }
                            else {
                                accessTypeListValue = accessTypeListValue + accessType;
                            }
                        }
                        mutableRequest.putHeader("Access-Type", accessTypeListValue);

                        break;
                    }
                }

                break;
            }
        }

        if (Objects.isNull(mutableRequest.getHeader("Restriction-List")) ||
                Objects.isNull(mutableRequest.getHeader("Restriction-Level")) ||
                Objects.isNull(mutableRequest.getHeader("Restriction-Base"))) {

            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
            return;
        }

        chain.doFilter(mutableRequest, response);
    }
}
