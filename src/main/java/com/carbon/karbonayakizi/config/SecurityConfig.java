package com.carbon.karbonayakizi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // In-memory kullanıcıları tanımlıyoruz
    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("user")
                        .password(passwordEncoder().encode("password"))
                        .roles("USER")
                        .build()
        );
    }
    // Güvenlik yapılandırmasını yapıyoruz
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // CSRF'yi devre dışı bırakıyoruz (API için gerekliyse)
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/users").authenticated()  // /users/add endpoint'ine yalnızca doğrulama yapılmış kullanıcılar erişebilir
                        .anyRequest().permitAll()  // Diğer tüm istekler serbest
                )
                .httpBasic(httpBasic -> {});  // Basic Authentication kullan
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // veya NoOpPasswordEncoder kullanabilirsiniz
    }


}
