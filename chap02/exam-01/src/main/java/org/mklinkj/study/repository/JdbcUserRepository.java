package org.mklinkj.study.repository;

import lombok.RequiredArgsConstructor;
import org.mklinkj.study.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class JdbcUserRepository implements UserRepository {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public User save(User user) {
    jdbcTemplate.update(
        """
                INSERT INTO t_user (username, password)
                VALUES (?, ?)
                """,
        ps -> {
          ps.setString(1, user.getUsername());
          ps.setString(2, user.getPassword());
        });
    // insert row 값을 검사할 필요는 없음, 중복된 값을 넣을 경우 update()에서 예외를 던짐
    return user;
  }

  @Override
  public int countByUsername(String username) {
    return jdbcTemplate.queryForObject(
        """
        SELECT COUNT(*)
          FROM t_user
         WHERE username = ?
        """,
        Integer.class,
        username);
  }
}
