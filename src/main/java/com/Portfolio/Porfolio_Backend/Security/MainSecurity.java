package com.Portfolio.Porfolio_Backend.Security;

import com.Portfolio.Porfolio_Backend.Security.JsonWebToken.JWTEntryPoint;
import com.Portfolio.Porfolio_Backend.Security.JsonWebToken.JWTFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity {
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JWTEntryPoint jwtEntryPoint;

    @Autowired
    JWTFilter jwtFilter;
    private static final String[] SECURED_URLs_Post = {"/habilidad","/educacion","/experiencia","/proyecto","/hero"};
    private static final String[] SECURED_URLs_Put_Delete = {"/habilidad/{id}","/educacion/{id}","/experiencia/{id}","/proyecto" +
            "/{id}",
            "/hero/{id}"};

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
       return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors().and()
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/auth/**").permitAll().and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.POST,SECURED_URLs_Post)
                .hasAuthority("ADMIN").and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.PUT,SECURED_URLs_Put_Delete)
                .hasAuthority("ADMIN").and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.DELETE,SECURED_URLs_Put_Delete)
                .hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
