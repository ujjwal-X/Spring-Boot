package org.boot08springsecurity.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider(){


        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);

//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12 ));


        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        System.out.println("User Applied CSRF setting applied");
        httpSecurity.csrf(c->c.disable());
        httpSecurity.authorizeHttpRequests(request-> request.anyRequest().authenticated());
        httpSecurity.httpBasic(Customizer.withDefaults());
//        httpSecurity.formLogin(Customizer.withDefaults());// show design login form
//        httpSecurity.httpBasic(h->h.disable()); // Disable HTTP Basic authentication
//        httpSecurity.formLogin(f->f.disable());// Disable form-based login
        httpSecurity.sessionManagement(
                session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    return httpSecurity.build();
    }

//    @Bean  // this method work with static values
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user1= User
//                .withDefaultPasswordEncoder()
//                .username("ujjwal")
//                .password("ujjwal123")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails admin= User
//                .withDefaultPasswordEncoder()
//                .username("root")
//                .password("root1")
//                .roles("USER")
//                .build();
//
//
//
//
//        return new InMemoryUserDetailsManager(user1,admin);
//    }

}
