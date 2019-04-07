package com.example.goopal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Hello world!
 */
@ServletComponentScan
@SpringBootApplication
public class SpringSessionDemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringSessionDemoApplication.class, args);
  }
}
