package com.example.goopal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;

import static org.springframework.data.redis.core.script.RedisScript.of;

/**
 * @author xinj.x
 */
//@EnableRedisHttpSession
@Configuration
public class SpringSessionConfig {
  private final RedisProperties redisProperties;

  @Autowired
  public SpringSessionConfig(RedisProperties redisProperties) {
    this.redisProperties = redisProperties;
  }

  @Bean
  public LettuceConnectionFactory connectionFactory() {
    RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisProperties
            .getHost(), redisProperties.getPort());
    redisStandaloneConfiguration.setPassword(RedisPassword.of(redisProperties.getPassword()));
    return new LettuceConnectionFactory(redisStandaloneConfiguration);
  }

  @Bean
  public ReactiveRedisTemplate<String, String> reactiveRedisTemplate() {
    return new ReactiveRedisTemplate<>(connectionFactory(), RedisSerializationContext.string());
  }

  @Bean
  public HttpSessionIdResolver httpSessionIdResolver() {
    return HeaderHttpSessionIdResolver.xAuthToken();
  }

  @Bean
  public RedisScript<Boolean> script() {
    return of("META-INF/scripts/checkandset.lua", Boolean.class);
  }
}
