package org.example.springmvcform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    @Autowired
//    private UserDetailsService userDetailsService;
  @Bean
    public SecurityFilterChain springSecurityFilterChain(HttpSecurity http) throws Exception {
     // http.authorizeHttpRequests(authorize-> authorize.requestMatchers("").authenticated().anyRequest().permitAll())
             http .csrf(CsrfConfigurer::disable)
              .authorizeHttpRequests(authorize-> authorize
              .requestMatchers("users/add/").permitAll()
              .requestMatchers("users/new").permitAll()
              .requestMatchers("users/add").permitAll()
              .requestMatchers("users/list").permitAll()
              .requestMatchers("/users").hasRole("ADMIN") );
             return http.build();
  }


}
