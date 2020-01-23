package com.Borman.cbbbluechips.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImp();
    }

    @Bean
    public CustomAuthenticationSuccessHandler getUserCustomAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().hasAnyRole("PLAYER", "ADMIN")
                .antMatchers("/leaderboard").hasRole("PLAYER") //TODO not working
                .and()
                .formLogin()
                .loginPage("/login").permitAll() // Specifies the login page URL// Specifies the URL,which is used in action attribute on the <from> tag
                .usernameParameter("email")  // Username parameter, used in name attribute of the <input> tag. Default is 'username'.
                .passwordParameter("password")  // Password parameter, used in name attribute of the <input> tag. Default is 'password'.
                .successHandler(getUserCustomAuthenticationSuccessHandler())
                .and()
                .logout().permitAll().logoutSuccessUrl("/login")
                .and()
                .csrf().disable();
    }

}