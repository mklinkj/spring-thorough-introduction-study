package org.mklinkj.study.jsr303;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

  @Bean
  A a() {
    return new A();
  }

  @Bean
  B b() {
    return new B();
  }

  public static class A {}

  public static class B {}
}
