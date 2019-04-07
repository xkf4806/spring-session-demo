package com.example.goopal.domain;

import lombok.Data;

/**
 * @author xinj.x
 */
@Data
public class RedisCheckAndSet {
  private String expectedValue;
  private String newValue;
}
