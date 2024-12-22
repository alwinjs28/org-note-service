package org.note.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // Allow Swagger UI and API Docs without authentication
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Use requestMatchers() instead of antMatchers()
                .anyRequest().authenticated()  // Require authentication for other endpoints
                .and()
                .httpBasic() // Enable Basic Authentication
                .and()
                .csrf().disable(); // Disable CSRF for stateless applications (if needed)

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt password encoding
    }

    // Define the hardcoded user credentials
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("user")
                        .password(passwordEncoder().encode("password"))
                        .roles("USER")
                        .build()
        );
    }

}
