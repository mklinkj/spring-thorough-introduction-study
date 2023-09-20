package org.mklinkj.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@Slf4j
@SpringJUnitConfig(Example01Application.class)
class Example01ApplicationTests {
  @Autowired private Set<String> nameSet;

  @Test
  void nameSet() {
    LOGGER.info("### nameSet Test ###");
    assertThat(nameSet).contains("mklinkj", "NTT DATA");
  }
}
