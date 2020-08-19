package com.Borman.cbbbluechips.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PlainTextPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("Setting up security");
        http.csrf().disable();


        http.authorizeRequests()
                .antMatchers("/", "/rules", "/rules/**")
                .permitAll();

        http.authorizeRequests()
                .antMatchers(
                        "/portfolio",
                        "/leaderboard",
                        "/market",
                        "/transactions",
                        "/settings",
                        "/settings/**",
                        "/comments",
                        "/comments/**",
                        "/trade/**",
                        "/trade-action/**",
                        "/data/**",
                        "/transactions",
                        "/transactions/**"
                )
                .hasAnyAuthority("USER");


        http.authorizeRequests().and().formLogin()//
                .loginPage("/")
                .loginProcessingUrl("/user/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/portfolio")
                .failureUrl("/?wasError=true")
                .and()
                .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/");
    }

}