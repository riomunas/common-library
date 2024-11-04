package asia.powerbiz.utils.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class RedisConfig {
    @Value("${spring.data.redis.host}")
    private String hostName;

    @Value("${spring.data.redis.port}")
    private int port;
    @Value("${spring.data.redis.username}")
    String username;
    @Value("${spring.data.redis.password}")
    String password;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {

        var redisConfig = new RedisStandaloneConfiguration(hostName, port);
        redisConfig.setUsername("");
        redisConfig.setPassword("");

        var jedisConfig = JedisClientConfiguration.builder().usePooling().build();

        return new JedisConnectionFactory(redisConfig, jedisConfig);
    }

}
