## Springboot Security Prectice
##### 04.16 최신화

#### 1. Dependencies
```text
- Spring Boot DevTools
- Lombok
- Spring Data JPA
- MySQL Driver
- Spring Security
- OAuth2 Client
- Spring Web

*추가한 의존성
- Tomcat_jasper
- JSTL
- Spring_security_taglibs
```

#### 2. MySQL
``` sql
create user 'park'@'%' identified by 'park1234';
GRANT ALL PRIVILEGES ON *.* TO 'park'@'%';
create database parkdb;
```

#### 3. Server Setting
```yml
server:
  port: 8080
  servlet:
    context-path: /
    encoding:
      charset: utf-8
      enabled: true
      
spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
      
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/parkdb?serverTimezone=Asia/Seoul
    username: park
    password: park1234
    
  jpa:
    open-in-view: true
    hibernate:
      ddl-auto: create
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
    
    # 콘솔에 출력되는 SQL문을 보기 좋게 만들어 줍니다.    
    show-sql: true
    properties:
      hibernate.format_sql: ture
      
  jackson:
    serialization:
      fail-on-empty-beans: false
```


