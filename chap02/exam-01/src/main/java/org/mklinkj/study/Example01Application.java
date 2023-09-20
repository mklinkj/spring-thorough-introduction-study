package org.mklinkj.study;

import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@Slf4j
public class Example01Application {

  @Bean
  Set<String> nameSet() {
    return Set.of("mklinkj", "NTT DATA");
  }

  public static void main(String[] args) {
    try (AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(Example01Application.class)) {

      LOGGER.info("### Application Initialized ### isRunning : {} ###", context.isRunning());

      @SuppressWarnings("unchecked")
      Set<String> nameSet = context.getBean("nameSet", Set.class);

      LOGGER.info("### nameSet: {} ###", nameSet);
    }
  }
}
