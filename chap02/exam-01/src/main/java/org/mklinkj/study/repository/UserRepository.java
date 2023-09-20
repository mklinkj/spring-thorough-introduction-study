package org.mklinkj.study.repository;

import org.mklinkj.study.domain.User;

public interface UserRepository {
  User save(User user);

  int countByUsername(String username);
}
