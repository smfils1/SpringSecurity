package com.spring.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.mvcMatchers("/").permitAll()
        .mvcMatchers("/h2-console/**").permitAll()
		.mvcMatchers("/customer").hasRole("CUSTOMER")
		.mvcMatchers("/customer/vip").hasAnyAuthority("ACCESS_DISCOUNT", "ROLE_CUSTOMER")
		.mvcMatchers("/admin").hasRole("ADMIN")
		.and()
		.csrf().disable()
        .headers().frameOptions().sameOrigin() //For h2 console
        .and()    
		.httpBasic();
		
	}
	
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    
    @Bean
    DaoAuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    	daoAuthenticationProvider.setUserDetailsService(userDetailService);
    	return daoAuthenticationProvider;
    }
}
