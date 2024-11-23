package com.myphotos.example.myphotos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {



    @SuppressWarnings("deprecation") 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("/admin").hasRole("ADMIN") // Solo gli ADMIN possono accedere a "/admin"
                .requestMatchers("/admin/**").hasRole("ADMIN") // Solo gli ADMIN possono accedere a "/admin/**"
                .requestMatchers("/").permitAll() // Accesso pubblico a "/"
                .and()
                .formLogin()
                .loginPage("/login") // Pagina di login personalizzata
                .permitAll()
                .and()
                .csrf().disable(); // Disabilita la protezione CSRF (non raccomandato in produzione)

        return http.build();
    }

   @Bean
    public UserDetailsService userDetailsService() {
        // Definizione di utenti in memoria
        UserDetails adminUser = User.builder()
            .username("admin")
            .password("{noop}admin")
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(adminUser);
    }
}
