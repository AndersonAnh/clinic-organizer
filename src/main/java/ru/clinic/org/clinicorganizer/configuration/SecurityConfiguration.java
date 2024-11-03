package ru.clinic.org.clinicorganizer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import static ru.clinic.org.clinicorganizer.security.Role.ADMIN;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/admin/**").hasRole(ADMIN.getAuthority()) // Доступ только для администраторов
                                .anyRequest().authenticated()) // Доступ для всех аутентифицированных пользователей
                .formLogin(login -> login.loginPage("/login") // Страница авторизации
                        .defaultSuccessUrl("/users") // Страница после успешной авторизации
                        .permitAll())
                .logout(LogoutConfigurer::permitAll); // Разрешить всем доступ к странице выхода
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
