package org.mklinkj.study.service;

import lombok.RequiredArgsConstructor;
import org.mklinkj.study.domain.User;
import org.mklinkj.study.exception.UserAlreadyRegisteredException;
import org.mklinkj.study.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;

  @Override
  public void register(User user, String rawPassword) {
    if (userRepository.countByUsername(user.getUsername()) > 0) {
      // 같은 사용자 계정의 사용자가 있다면 예외를 발생시킴
      throw new UserAlreadyRegisteredException();
    }

    // 입력된 원본 패스워드를 해시화한 후, 사용자 정보로 설정
    user.setPassword(passwordEncoder.encode(rawPassword));
    this.userRepository.save(user);
  }
}
