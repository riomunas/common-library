package asia.powerbiz.filterauthorizationkeycloack.repositories.redis;

import asia.powerbiz.filterauthorizationkeycloack.entities.redis.UserWorkspaceAccess;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

@Deprecated
public class RedisRepository {
    private String redishHash;
    private HashOperations hashOperations;

    public RedisRepository(String redishHash, RedisTemplate redisTemplate) {
        this.redishHash = redishHash;
        hashOperations = redisTemplate.opsForHash();
    }

    public void create(UserWorkspaceAccess workspace) {
        hashOperations.put(redishHash, workspace.getUserId(), workspace);
    }

    public String get(UserWorkspaceAccess workspace) {
        return (String) hashOperations.get(redishHash, workspace.getUserId());
    }

    public void update(UserWorkspaceAccess workspace) {
        try {
            hashOperations.put(redishHash, workspace.getUserId(), new ObjectMapper().writeValueAsString(workspace));
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
