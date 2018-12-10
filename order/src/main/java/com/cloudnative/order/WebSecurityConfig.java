package com.cloudnative.order;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
  protected void configure(HttpSecurity http) throws Exception
  {
      http
      .csrf().disable()
      .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS).permitAll() // allow CORS option calls
        .antMatchers("/resources/**").permitAll()
        .anyRequest().authenticated()
      .and()
      .formLogin()
      .and()
      .httpBasic();
  }
}