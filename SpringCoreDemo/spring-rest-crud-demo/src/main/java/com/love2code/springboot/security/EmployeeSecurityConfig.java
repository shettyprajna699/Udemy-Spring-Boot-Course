//package com.love2code.springboot.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class EmployeeSecurityConfig {
//   /* @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails john= User.builder()
//                .username("john")
//                .password("{noop}emp123")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails mary= User.builder()
//                .username("john")
//                .password("{noop}emp123")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//        UserDetails susan= User.builder()
//                .username("john")
//                .password("{noop}emp123")
//                .roles("EMPLOYEE","Manager","ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(john,mary,susan);
//
//    }*/
//   @Bean
//   public UserDetailsManager userDetailsManager(DataSource datasource){
//       return new JdbcUserDetailsManager(datasource);
//   }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(configurer->
//                configurer
//                        .requestMatchers(HttpMethod.GET, "/emp").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.GET, "/emp/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST, "/emp").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT, "/emp").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.DELETE, "/emp/**").hasRole("ADMIN")
//        );
//        //use HTTP basic authentication
//        http.httpBasic(Customizer.withDefaults());
//        //disable cross site Request forgery(csrf)
//        //in general, not required for stateless REST APIs that use POST,PUT,DELETE and/or PATCH
//        http.csrf(csrf->csrf.disable());
//        return http.build();
//
//    }
//
//}
