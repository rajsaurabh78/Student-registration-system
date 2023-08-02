package com.masai.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

//	@Bean
//	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {
//
//		http.authorizeHttpRequests()
//		.requestMatchers(HttpMethod.POST, "/admin").permitAll()
//		.anyRequest()
//		.authenticated()
//		.and().csrf().disable()
//		.formLogin()
//		.and().httpBasic();
//
//		return http.build();
//
//	}
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
//		
//		httpSecurity.authorizeHttpRequests().requestMatchers(HttpMethod.POST,"/admin").permitAll()
//		.anyRequest().authenticated().and().csrf().disable().formLogin().and().httpBasic();
//		return httpSecurity.build();
//	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//
//		return new BCryptPasswordEncoder();
//
//	}

}
