package com.example.finalprojectspringcarrent.configurations;

import com.example.finalprojectspringcarrent.services.implementations.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.example.finalprojectspringcarrent.utils.Constants.Security.*;


/**
 * @author Tiina Raudla
 * @Date
 */

@Configuration
@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService());
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        String role = "ROLE_";
        String owner = AUTHORITY_OWNER.replace(role, "");
        String customer = AUTHORITY_CUSTOMER.replace(role, "");
        String employee = AUTHORITY_EMPLOYEE.replace(role, "");

        httpSecurity.authorizeRequests()
                .antMatchers("/", "/templates/user/signup/**")
                .permitAll()
                .antMatchers("/templates/user")
                .hasRole(owner)
                .antMatchers("/branch/**")
                .hasAnyRole(customer, employee, owner)
                .antMatchers("/rental/**")
                .hasAnyRole(employee)
                .antMatchers("/booking/**")
                .hasRole(customer)
                .and()
                .httpBasic()
                .and()
                .formLogin()
                .and()
                .logout().permitAll(false).logoutSuccessUrl("/")
                .and()
                .csrf().disable();
    }
}
