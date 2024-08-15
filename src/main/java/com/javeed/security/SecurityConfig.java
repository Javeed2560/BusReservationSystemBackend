
package com.javeed.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.javeed.services.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

	@Autowired
	private CorsConfig corsConfigurer;
	
	@Autowired
	private JWTEntryPoint jwtEntryPoint;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private JWTAuthFilter jwtAuthFilter;
	
	@Bean
	SecurityFilterChain deafultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests((authReq) -> authReq.requestMatchers(HttpMethod.GET)
					.permitAll()
					.requestMatchers("/api/auth/**")
					.permitAll()
					.requestMatchers(HttpMethod.POST,
									"/api/bus/add",
									"api/schedule/add",
									"api/route/add")
					.authenticated()
					.requestMatchers(HttpMethod.POST,"/api/reservation/add")
					.permitAll())
			.exceptionHandling(exception -> exception.authenticationEntryPoint(jwtEntryPoint))
			.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(jwtAuthFilter,UsernamePasswordAuthenticationFilter.class);
		http.cors().configurationSource(CorsConfigurationSource());
		return http.build();
		
	}

	private CorsConfigurationSource CorsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
       // config.addAllowedOrigin("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        config.addAllowedOriginPattern("*");
        config.setAllowCredentials(true);
        source.registerCorsConfiguration("/**", config);
        return source;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
		return configuration.getAuthenticationManager();
	}
	
}
