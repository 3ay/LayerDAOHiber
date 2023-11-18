package com.netology.layerdaohiber.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and()
                .authorizeHttpRequests().anyRequest().authenticated()
                .and();

    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Admin")
                .password(passwordEncoder().encode("1234"))
                .authorities("ALL")
                .and()
                .withUser("klark")
                .password(passwordEncoder().encode("1234"))
                .roles("READ")
                .and()
                .withUser("james")
                .password(passwordEncoder().encode("1234"))
                .roles("WRITE")
                .and()
                .withUser("morty")
                .password(passwordEncoder().encode("1234"))
                .roles("DELETE","WRITE");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
