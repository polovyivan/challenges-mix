package jedisdemo.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;

@Configuration
public class SpringConfig {

  @Value("${redis.host}")
  private String host;

  @Value("${redis.password}")
  private String password;

  @Value("${redis.port}")
  private int port;


  @Value("${redis.jedis.pool.max-total}")
  private int maxTotal;

  @Value("${redis.jedis.pool.max-idle}")
  private int maxIdle;

  @Value("${redis.jedis.pool.min-idle}")
  private int minIdle;

  @Bean
  public JedisClientConfiguration getJedisClientConfiguration() {
    JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jedisClientConfigurationBuilder = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration
        .builder();
    GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
    genericObjectPoolConfig.setMaxIdle(maxIdle);
    genericObjectPoolConfig.setMinIdle(minIdle);
    genericObjectPoolConfig.setMaxTotal(maxTotal);
    return jedisClientConfigurationBuilder.poolConfig(genericObjectPoolConfig).build();
  }

  @Bean
  public JedisConnectionFactory getJedisConnectionFactory() {
    RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
    redisStandaloneConfiguration.setHostName(host);
    if (!StringUtils.isEmpty(password)) {
      redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
    }
    redisStandaloneConfiguration.setPort(port);
    return new JedisConnectionFactory(redisStandaloneConfiguration, getJedisClientConfiguration());
  }

  @Bean
  public RedisTemplate redisTemplate() {
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(getJedisConnectionFactory());
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    return redisTemplate;
  }

  @Bean
  @Qualifier("listOperations")
  public ListOperations<String, Programmer> listOperations(
      RedisTemplate<String, Programmer> redisTemplate) {
    return
        redisTemplate.opsForList();
  }

  @Bean
  @Qualifier("setOperations")
  public SetOperations<String, Programmer> setOperations(
      RedisTemplate<String, Programmer> redisTemplate) {
    return
        redisTemplate.opsForSet();
  }

  @Bean
  @Qualifier("hashOperations")
  public HashOperations<String, Integer, Programmer> hashOperations(
      RedisTemplate<String, Programmer> redisTemplate) {
    return
        redisTemplate.opsForHash();
  }
}
