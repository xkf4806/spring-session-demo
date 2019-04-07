package com.example.goopal.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * @author xinj.x
 */
@Data
@ToString
@Builder
@RedisHash(value = "jedis:person",timeToLive = 60)
public class Person {
  @Id
  private String id;
  @Indexed
  private String firstName;
  private String finalName;
  private Address address;

  @Data
  @Builder
  @ToString
  public static class Address {
    private String province;
    private String city;
  }
}
