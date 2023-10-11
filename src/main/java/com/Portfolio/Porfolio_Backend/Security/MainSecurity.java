package com.Portfolio.Porfolio_Backend.Security;

import com.Portfolio.Porfolio_Backend.Security.JsonWebToken.JWTEntryPoint;
import com.Portfolio.Porfolio_Backend.Security.JsonWebToken.JWTFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;




@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class MainSecurity {
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JWTFilter jwtFilter;
    
    @Autowired
    JWTEntryPoint jwtEntryPoint;
    
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
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST,SECURED_URLs_Post).hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT,SECURED_URLs_Put_Delete)
                                .hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,SECURED_URLs_Put_Delete)
                                .hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, SECURED_URLs_Post).permitAll()
                        .anyRequest().authenticated()
                        
                )
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement() .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
