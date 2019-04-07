package com.example.goopal.controller;

import com.example.goopal.domain.RedisPubObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author xinj.x
 */
@RestController
@RequestMapping(value = "/redis")
public class RedisPubSubController {
  @Autowired
  private RedisTemplate redisTemplate;

  @PostMapping(value = "/pub")
  public void pub(@RequestBody RedisPubObj redisPubObj) {
    redisTemplate.convertAndSend(redisPubObj.getChannel(), redisPubObj.getMessage());
  }

}
