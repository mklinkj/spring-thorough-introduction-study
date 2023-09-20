package org.mklinkj.study.service;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mklinkj.study.Example01Application;
import org.mklinkj.study.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@Slf4j
@SpringJUnitConfig(Example01Application.class)
@Sql(
    scripts = "classpath:sql/initialize_db.sql",
    executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
class UserServiceImplTests {

  @Autowired private UserService userService;

  @Autowired private PasswordEncoder passwordEncoder;

  @Test
  void testRegister() {
    User paramUser =
        User.builder() //
            .username("user00")
            .password("1234")
            .build();

    userService.register(paramUser, paramUser.getPassword());
    assertThat(passwordEncoder.matches("1234", paramUser.getPassword())).isTrue();
  }
}
