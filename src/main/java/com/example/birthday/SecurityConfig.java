package com.example.birthday;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // CSRF 보호 비활성화
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()  // 모든 요청 인증 없이 허용
                )
                .formLogin(login -> login
                        .loginPage("/login")   // 사용자 정의 로그인 페이지 유지
                        .defaultSuccessUrl("/welcome", true) // 로그인 성공 후 이동
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());  // 로그아웃 허용

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("sunyoungeya")
                .password("20250205")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
