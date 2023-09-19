#  04장. 스프링 MVC 기초

> `06장 RESTful 웹서비스 개발` 챕터 먼저 하려고 했는데, 예제의 뼈대 프로젝트 만들다 보니 4장 예제를 먼저 진행해보게 되었다.

## 진행

* 저자님 예제를 참고해서 Spring 6 버전 기반으로 예제를 만들어봤음.



* web.xml 설정을 보면 특이한 부분이 있다.

  프로젝트의 모든 JSP의 앞부분에 미리 테그라이브러리 선언 같은 것을 추가해주는 설정부가 있음.

  ```jsp
     <jsp-config>
        <jsp-property-group>
            <url-pattern>*.jsp</url-pattern>
            <page-encoding>UTF-8</page-encoding>
            <include-prelude>/WEB-INF/include.jsp</include-prelude>
        </jsp-property-group>
    </jsp-config>
  ```

  * 테그 라이브러리도 버전을 올려놔서 네임스페이스를 바꿔서 써도 되긴되는데... 그렇게 하려면 신버전이 서버에 올라가도록 scope를 compile로 바꿔야함.
    * https://jakarta.ee/specifications/tags/3.0/jakarta-tags-spec-3.0#multiple-tag-libraries
    * 그러나 안하는게 낫겠다. Jetty 11에 포함된 JSTL라이브러리는 최신 네임스페이스를 쓸 수 없음.
      * scope를 compile로 바꾸고 Tocmat을 쓴다면 문제 없음.

  



---

## 의견

* 오랜만에 Jetty 자동 배포 설정확인해보니... 지금은 Java Config 기반이라도 잘되는 것 같다. 
  * 그런데... web.xml도 Java Config으로 옮긴 것은 아니여서... 이걸 바꾸면 또 안될 수도 있음 😅





## 정오표

* ...
