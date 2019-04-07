package com.example.goopal.controller;

import com.example.goopal.domain.RedisCheckAndSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

/**
 * @author xinj.x
 */
@RestController
public class RedisScriptController {
  @Autowired
  private RedisScript<Boolean> script;
  @Autowired
  private RedisTemplate redisTemplate;

  @PostMapping(value = "/checkAndSet")
  public Boolean checkAndSet(@RequestBody RedisCheckAndSet redisCheckAndSet) {
    return (Boolean) redisTemplate.execute(script, singletonList("name"), asList(redisCheckAndSet.getExpectedValue(),
            redisCheckAndSet.getNewValue()));
  }
}
