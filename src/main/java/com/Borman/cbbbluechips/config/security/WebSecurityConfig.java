package com.Borman.cbbbluechips.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PlainTextPasswordEncoder());
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();//Used for auto login of create user
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("Setting up security");
        http.csrf().disable();


        http.authorizeRequests()
                .antMatchers("/", "/rules", "/rules/**")
                .permitAll();

        http.authorizeRequests()
                .antMatchers("/admin", "/admin/**")
                .hasAnyAuthority("ADMIN");

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

        http.rememberMe()
                .alwaysRemember(true)
                .key("1063")
                .rememberMeCookieName("remember-me-auto-login")
                .tokenValiditySeconds(10000000);

    }

}