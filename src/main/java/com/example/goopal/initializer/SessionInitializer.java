package com.example.goopal.initializer;

import com.example.goopal.config.SpringSessionConfig;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * @author xinj.x
 */
public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {
  public SessionInitializer() {
    super(SpringSessionConfig.class);
  }
}
