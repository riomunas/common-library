package asia.powerbiz.filterauthorizationkeycloack.repositories.redis;

import asia.powerbiz.filterauthorizationkeycloack.entities.redis.UserWorkspaceAccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@Slf4j
public class WorkspaceRepositoryImpl implements WorkspaceRepository {
    private final StringRedisTemplate stringRedisTemplate;
    private final ObjectMapper objectMapper;
    private final String hashKey;

    WorkspaceRepositoryImpl(@Qualifier(value = "keycloakStringRedisTemplate") StringRedisTemplate stringRedisTemplate,
                                   ObjectMapper objectMapper,
                                   @Value("${app.hash-key}") String hashKey){
        this.objectMapper = objectMapper;
        this.hashKey = hashKey;
        this.stringRedisTemplate = stringRedisTemplate;

    }

    @Override
    public Optional<UserWorkspaceAccess> findById(String id){
        try{
            String result = (String) stringRedisTemplate.opsForHash().get(hashKey, id);
            if (Objects.isNull(result)) return Optional.empty();
            return Optional.ofNullable(objectMapper.readValue(result, UserWorkspaceAccess.class));
        } catch (Exception e){
            log.error("WorkspaceRepository::findById: error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
