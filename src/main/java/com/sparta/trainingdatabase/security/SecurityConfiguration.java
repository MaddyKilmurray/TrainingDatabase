package com.sparta.trainingdatabase.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final AuthUserDetailService authUserDetailService;

    public SecurityConfiguration(AuthUserDetailService authUserDetailService) {
        this.authUserDetailService = authUserDetailService;
    }

    @Bean
    public AuthenticationManager customAuthenticationManager(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(
                AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(authUserDetailService)
                .passwordEncoder(noOpPasswordEncoder());
        return authenticationManagerBuilder.build();
    }

    // Test and replace with another encoder
    @Bean
    public PasswordEncoder noOpPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()
                .disable()
                .requestCache()
                .disable()
                .authorizeRequests()
                .antMatchers("/signup","/webjars/bootstrap/4.1.2/css/bootstrap.min.css")
                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .hasAnyAuthority("ADMIN","USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                .exceptionHandling().accessDeniedPage("/accessdenied");
        return httpSecurity.build();
    }
}
