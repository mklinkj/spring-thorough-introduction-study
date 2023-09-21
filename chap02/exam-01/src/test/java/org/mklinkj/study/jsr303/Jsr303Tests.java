package org.mklinkj.study.jsr303;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mklinkj.study.jsr303.TestConfig.A;
import org.mklinkj.study.jsr303.TestConfig.B;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(TestConfig.class)
public class Jsr303Tests {
  @Inject private A a;

  @Inject private B b;

  @Test
  void a() {
    assertThat(a).isNotNull();
  }

  @Test
  void b() {
    assertThat(b).isNotNull();
  }
}
