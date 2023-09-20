package org.mklinkj.study.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mklinkj.study.Example01Application;
import org.mklinkj.study.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@Slf4j
@SpringJUnitConfig(Example01Application.class)
@Sql(
    scripts = "classpath:sql/initialize_db.sql",
    executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
class JdbcUserRepositoryTests {

  @Autowired
  @Qualifier("jdbcUserRepository")
  private UserRepository jdbcUserRepository;

  @Autowired private PasswordEncoder passwordEncoder;

  @Test
  void testCountByUsername() {
    int result = jdbcUserRepository.countByUsername("mklinkj");
    assertThat(result).isEqualTo(1);

    jdbcUserRepository.countByUsername("NTT DATA");
    assertThat(result).isEqualTo(1);
  }

  @DisplayName("존재하지 않는 유저 조회")
  @Test
  void testCountByUsername_NotExist() {
    int result = jdbcUserRepository.countByUsername("NOT EXIST");
    assertThat(result).isEqualTo(0);
  }

  @Test
  void testSave() {
    User paramUser =
        User.builder() //
            .username("user00")
            .password(passwordEncoder.encode("1212"))
            .build();
    User user = jdbcUserRepository.save(paramUser);

    assertThat(user).isEqualTo(paramUser);
  }

  @Test
  void testSave_AlreadyUser() {
    User paramUser =
        User.builder() //
            .username("NTT DATA")
            .password(passwordEncoder.encode("aaaa"))
            .build();

    assertThatThrownBy(() -> jdbcUserRepository.save(paramUser))
        .isInstanceOf(DuplicateKeyException.class);
  }
}
