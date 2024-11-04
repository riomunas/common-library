package asia.powerbiz.utils.repositories;

import asia.powerbiz.utils.entities.RetryCacheEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class RetryCacheRepositoryImpl implements RetryCacheRepository{
    private final RedisTemplate<String, RetryCacheEntity> retryCacheRedisTemplate;
    private final RedisTemplate<String, String> stringRedisTemplate;
    @Value("${app.error-mechanism.cache-entity-prefix}")
    private String ENTITY_PREFIX;

    @Value("${app.error-mechanism.key-list-prefix}")
    private String KEY_LIST;

    @Override
    public void save(RetryCacheEntity entity) {
        retryCacheRedisTemplate.opsForValue().set(ENTITY_PREFIX.concat(entity.getId()), entity);
        stringRedisTemplate.opsForList().rightPush(KEY_LIST, entity.getId());
    }

    @Override
    public Optional<RetryCacheEntity> findById(String id){
        return Optional.ofNullable(retryCacheRedisTemplate.opsForValue().get(ENTITY_PREFIX.concat(id)));
    }

    @Override
    public List<String> findAllKey(){
        return stringRedisTemplate.opsForList().range(KEY_LIST, 0, -1);
    }

    @Override
    public void deleteIdIn(List<String> ids) {
        retryCacheRedisTemplate.opsForValue().getOperations().delete(ids);
        ids.forEach(s -> stringRedisTemplate.opsForList().remove(KEY_LIST, 0, s));
    }

}
