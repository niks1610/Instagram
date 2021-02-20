package com.craterzone.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.craterzone.demo.service.MyUserDetailService;

//import net.bytebuddy.agent.builder.AgentBuilder.Default.NativeMethodStrategy.Disabled;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserDetailService userDetailService;
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
		 		.csrf()
				.disable()
				.cors()
				.disable()
				.authorizeRequests()
				.antMatchers("/token").permitAll()
				.antMatchers(HttpMethod.POST,"/api/v1/users/").permitAll()
				.antMatchers(HttpMethod.POST, "/api/v1/users/login").permitAll()
				.antMatchers(HttpMethod.GET, "/api/v1/users/{id}").permitAll()
				.anyRequest().authenticated()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 	
	http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);	
		
		
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailService);
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public AuthenticationManager getAuthenticationManager() throws Exception
	{
			
		return super.authenticationManagerBean();
	}
}
