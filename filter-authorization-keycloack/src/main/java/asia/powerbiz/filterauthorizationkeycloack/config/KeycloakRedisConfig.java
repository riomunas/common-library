package asia.powerbiz.filterauthorizationkeycloack.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class KeycloakRedisConfig {

    @Value("${spring.data.redis.host}")
    private String hostName;

    @Value("${spring.data.redis.port}")
    private int port;
    @Value("${spring.data.redis.username}")
    String username;
    @Value("${spring.data.redis.password}")
    String password;

    @Bean
    public JedisConnectionFactory keycloackJedisConnectionFactory() {

        var redisConfig = new RedisStandaloneConfiguration(hostName, port);
        redisConfig.setUsername("");
        redisConfig.setPassword("");
//        redisConfig.setDatabase(DB);

        var jedisConfig = JedisClientConfiguration.builder().usePooling().build();

        return new JedisConnectionFactory(redisConfig, jedisConfig);
    }

    @Bean(name = "keycloakStringRedisTemplate")
    public StringRedisTemplate stringRedisTemplate(){
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(keycloackJedisConnectionFactory());
        return template;
    }
}
