package com.example.projectdemex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableMethodSecurity
public class SpringConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                        // Разрешаем доступ без аутентификации
                        .requestMatchers(
                                "/",
                                "/activate/**",
                                "/webjars/**",
                                "/js/**",
                                "/css/**",
                                "/img/**",
                                "/uploads/**",
                                "/sw.js",
                                "/complaint.html",
                                "/home.html"
                        ).permitAll()

                        // Админские страницы
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/complaint.html").permitAll()
                       /* .requestMatchers("/static/complaint.html").permitAll()*/

                        // Все остальные запросы требуют аутентификации
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/complaint")
                        .defaultSuccessUrl("/")
                        .permitAll()
                )
                .rememberMe(rememberMe -> rememberMe
                        .key("A6OzwHU19WzPexMsBAfC")
                        .tokenValiditySeconds(86400)
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                        .deleteCookies("JSESSIONID")
                );

        return http.build();
    }
}