package com.park.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// AuthenticationFilter를 만드는 과정.

@Configuration // 1. 메모리에 띄워줍니다.
@EnableWebSecurity // 2. 시큐리티 재정의를 위해 어노테이션을 달아줍니다.
// 3. WebSecurityConfigurerAdapter를 이용해 원하는 추상 메서드만 오버라이딩 해줍니다.
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// 4. configure을 오버라이딩 해줘서 시큐리티를 재정의 합니다.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 5. csrf 정책을 차단합니다.
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/user", "/post").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
		.antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
		.anyRequest()
		.permitAll()
		.and()
		.formLogin()
		.loginPage("/loginForm")
		.loginProcessingUrl("/login");
		
	}

}
