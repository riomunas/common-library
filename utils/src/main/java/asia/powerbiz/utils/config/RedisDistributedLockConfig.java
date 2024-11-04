package asia.powerbiz.utils.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.integration.support.locks.ExpirableLockRegistry;

import java.time.Duration;

@Configuration
public class RedisDistributedLockConfig {
    @Value("${spring.data.lock.distributed-lock-key}")
    private String REDIS_DISTRIBUTED_LOCK_KEY;

    @Value("${spring.data.lock.duration}")
    private int REDIS_LOCK_DURATION;

    @Bean
    public ExpirableLockRegistry lockRegistry(@Qualifier(value = "jedisConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
        return new RedisLockRegistry(redisConnectionFactory, REDIS_DISTRIBUTED_LOCK_KEY,
                Duration.ofMinutes(REDIS_LOCK_DURATION).toMillis());
    }

}