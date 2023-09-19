package org.mklinkj.study.app;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EchoForm implements Serializable {

  private static final long serialVersionUID = 1115232259783191726L;

  @NotEmpty
  @Size(max = 100)
  private String text;
}
