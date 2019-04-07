package com.example.goopal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author xinj.x
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ReactiveRedisOperationTest {
  @Autowired
  private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

  @Test
  public void addLink() throws MalformedURLException {
    URL url = new URL("http://www.baidu.com");
    Long user001 = reactiveRedisTemplate.opsForList().leftPush("user001", url.toExternalForm()).block();
    log.info("reactive redis operation: {}", user001);
  }
}
