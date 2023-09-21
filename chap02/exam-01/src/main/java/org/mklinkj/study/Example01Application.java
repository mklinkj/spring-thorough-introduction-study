package org.mklinkj.study;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.mklinkj.study.domain.User;
import org.mklinkj.study.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@Slf4j
public class Example01Application {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(Example01Application.class);
    context.registerShutdownHook();

    LOGGER.info(
        "### profile: {} ###", Arrays.toString(context.getEnvironment().getActiveProfiles()));

    LOGGER.info("### Application Initialized ### isRunning : {} ###", context.isRunning());

    User user =
        User.builder() //
            .username("user99")
            .password("1234")
            .build();

    LOGGER.info("### Register User: {} ###", user);
    UserService userService = context.getBean(UserService.class);
    // ✨ 내가 약간 해깔리던 부분이 있는데, 빈 이름이 상위 인터페이스의 첫글자만 소문자인 이름으로 ("userService")
    //    자동설정되는 줄 알고 착각하고 있었다.
    //    @Autowired의 기본은 타입 기준으로 와이어링됨.
    // UserService userService = context.getBean("userServiceImpl", UserServiceImpl.class);
    userService.register(user, user.getPassword());
  }
}
