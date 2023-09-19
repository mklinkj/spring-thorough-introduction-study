package org.mklinkj.study.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mklinkj.study.config.AppConfig;
import org.mklinkj.study.config.WebMvcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringJUnitWebConfig(classes = {AppConfig.class, WebMvcConfig.class})
class EchoControllerTests {

  private MockMvc mockMvc;

  @Autowired private WebApplicationContext context;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  void testViewInput() throws Exception {
    mockMvc
        .perform(get("/echo"))
        .andExpect(status().isOk())
        .andExpect(view().name("echo/input"))
        .andDo(print());
  }

  @Test
  void testEcho_Success() throws Exception {
    mockMvc
        .perform(
            post("/echo") //
                .param("text", "Hello"))
        .andExpect(status().isOk())
        .andExpect(view().name("echo/output"))
        // `input.jsp`에 spring form 태그에 `modelAttribute`가 설정 되어 있음
        .andExpect(model().attributeExists("echoForm"))
        .andDo(print());
  }

  @Test
  void testEcho_Validation_Failure() throws Exception {
    mockMvc
        .perform(
            post("/echo") //
                .param("text", ""))
        .andExpect(status().isOk())
        .andExpect(view().name("echo/input"))
        .andDo(print());
  }
}
