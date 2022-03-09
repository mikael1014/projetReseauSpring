package org.mn.projetreseauspring.security;

import org.mn.projetreseauspring.entiy.enum_.RoleUtilisateur;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
//@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private final DetailsUtilisateurServices detailsUtilisateurServices;
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

	public SecurityConfiguration(DetailsUtilisateurServices detailsUtilisateurServices, CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
		this.detailsUtilisateurServices = detailsUtilisateurServices;
		this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		// AuthenticationProvider daoAuthentificationProvider;
		auth.authenticationProvider(daoAuthentificationProvider());
	}

	@Bean
	public AuthenticationProvider daoAuthentificationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(detailsUtilisateurServices);
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
		return daoAuthenticationProvider;
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilter(new JWTAuthentificationFilter(authenticationManager()))
		.addFilter(new JWTAuthorizationFilter(authenticationManager()))
		.authorizeRequests()
//		.httpBasic().and().authorizeRequests()
		
		.antMatchers("/api/secured").authenticated()
		.antMatchers("/login").permitAll()
		.antMatchers("/api/secured/admin").hasRole(RoleUtilisateur.ADMIN.name()) // commencer par les plus specifique pour finir par les generaux
		.and()
		.formLogin()
			.loginPage("/")
			.loginProcessingUrl("/authenticateUtilisateur")
			.successHandler(customAuthenticationSuccessHandler)
			.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http.authorizeRequests() .antMatchers("/*").permitAll()
	 * .antMatchers("/user/*").hasAnyRole("USER", "ADMIN")
	 * .antMatchers("/admin/*").hasRole("ADMIN") .and() .formLogin() .loginPage("/")
	 * .loginProcessingUrl("/authenticateUtilisateur")
	 * .successHandler(customAuthenticationSuccessHandler) .permitAll() .and()
	 * .logout().permitAll() .and()
	 * .exceptionHandling().accessDeniedPage("/access-denied");
	 * 
	 * // http.authorizeRequests().antMatchers("/").permitAll().and() //
	 * .authorizeRequests().antMatchers("/h2-console/**").permitAll(); //
	 * http.csrf().disable(); // http.headers().frameOptions().disable(); }
	 */
}