package com.Formula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService getUserDetailsService() {
		return new CustomeUserDetailService();
	}
	
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider(){
		DaoAuthenticationProvider daoAuthenticationProvider = new  DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/","/signin","/reset/password").permitAll() // Permit access to /signin for all users
                .antMatchers("/register")    //register only authorized by admin
                .hasAnyAuthority("admin")
                .anyRequest().authenticated() // Require authentication for all other requests
            .and()
            .formLogin().loginPage("/signin").loginProcessingUrl("/userLogin")
            .defaultSuccessUrl("/get/all/rawMaterial",true).permitAll()    //here after successfully the next page should be raw.jsp
            .and()
            .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/signin") // Redirect to signin page after logout
                .permitAll(); 
        return http.build();
    }
	 

}
