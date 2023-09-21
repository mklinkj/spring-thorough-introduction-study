#  02장. 스프링 코어 (DI, AOP)

> 제공 예제가 없지만, 그냥 예제를 만들어볼까? 🤔
>
> 모든 내용을 예제로 만들려고 하지말고, 큰그림만 예제로 만들자~

## 진행

- [ ] 한번 읽어보기!

### [exam-01](exam-01) 예제

* **범위:** `2.1 DI`에서 궁금한 내용 테스트
  *  ... ~  p75







---

## 의견

* ...



## 기타

Gralde 프로젝트에서는 application 플러그인 실행해서 main 메서드가 담긴 클래스 지정해서 실행을 했었는데..

maven이라면 exec-maven-plugin 설정을 해줘야한다.

```xml
  <build>
    <plugins>
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <version>${exec-maven-plugin.version}</version>
        <configuration>
          <mainClass>org.mklinkj.study.Example01Application</mainClass>
        </configuration>
      </plugin>
    </plugins>
  </build>
```

콘솔에서 실행할 때는 다음과 같이 실행

```sh
mvn clean compile exec:java
```

* compile을 해야함. exec:java가 알아서 이전 단계를 수행하지 않음.
  * `exec:java`만 실행할 때.. compile을 알아서 수행되게 하는 설정은 안보이는데.. 추후 알게 되면 내용 적어두자!



## 정오표

* ...
