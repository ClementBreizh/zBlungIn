package com.apsidepoei.projetpoei.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.apsidepoei.projetpoei.securityservice.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsServiceImpl userDetailsServiceImpl;

//  @Autowired
//  private CustomLogoutHandler customLogoutHandler;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsServiceImpl);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    http
//    .authorizeRequests()
//      .anyRequest().authenticated()
//      .antMatchers(HttpMethod.GET).authenticated()
//      .antMatchers(HttpMethod.POST).authenticated()
//    .and()
//      .csrf()
//        .ignoringAntMatchers("/logout")
//    .and()
//    .logout()
//    .addLogoutHandler(customLogoutHandler)
//    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//    .logoutSuccessUrl("/").deleteCookies("JSESSIONID")
//    .and()
//      .httpBasic()
//    .and()
//      .cors();
    http
      .authorizeRequests()
        .anyRequest().authenticated()
      .and()
        .formLogin().permitAll()
      .and()
        .logout().permitAll()
      .and()
        .httpBasic()
      .and()
        .csrf().disable();

  }

//  @Bean
//  public CustomLogoutHandler logoutHandler() {
//      return new CustomLogoutHandler();
//  }

  @Bean
  public UserDetailsServiceImpl beanUserDetailsServiceImpl() {
    return new UserDetailsServiceImpl();
  }

  @Bean
  public AuthenticationManager beanAuthenticationManager() throws Exception {
    return this.authenticationManager();
  }
}
