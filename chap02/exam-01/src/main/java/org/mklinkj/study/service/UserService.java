package org.mklinkj.study.service;

import org.mklinkj.study.domain.User;

public interface UserService {
  void register(User user, String rawPassword);
}
