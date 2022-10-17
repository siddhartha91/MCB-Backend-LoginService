//package com.mcb.app.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@SuppressWarnings("deprecation")
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
////	@Bean
////	AuthenticationProvider getAuthenticationProviderBean() {
////		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
////		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
////		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoderBean());
////		return daoAuthenticationProvider;
////	}
//
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.cors();
////		http.csrf().disable().authorizeRequests().antMatchers("/mcb/api/homepage","/mcb/api/user").permitAll()
////				.antMatchers("/mcb/api/transactions/create", "/mcb/api/transactions/update",
////						"/mcb/api/transactions/view", "/mcb/auth/login")
////				.hasAuthority("ADMIN").antMatchers("/mcb/api/transactions/delete/{id}").hasAuthority("MANAGER")
////				.antMatchers("/mcb/api/transactions/view/{id}").hasAuthority("USER").anyRequest().authenticated();
////				//.and()
////				//.httpBasic().and().formLogin();
////	}
//
////    @Bean
////    PasswordEncoder getPasswordEncoderBean(){
////        return NoOpPasswordEncoder.getInstance();
////    }
//
//	@Bean
//	PasswordEncoder getPasswordEncoderBean() {
//		return new BCryptPasswordEncoder();
//	}
//
//}
