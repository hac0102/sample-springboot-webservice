package com.sample.board.springboot.config.auth;

import com.sample.board.springboot.web.dto.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
            .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/common/**","/login2").permitAll()
//                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
            .and()
                .logout()
                .logoutSuccessUrl("/")
//                .invalidateHttpSession(true)
            .and()
                .oauth2Login()
                .loginPage("/login2")
                .defaultSuccessUrl("/")
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}
