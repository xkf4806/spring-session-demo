package com.example.goopal.domain;

import lombok.Data;

/**
 * @author xinj.x
 */
@Data
public class RedisPubObj {
  private String channel;
  private Object message;
}
