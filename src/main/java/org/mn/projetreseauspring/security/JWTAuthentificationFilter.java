package org.mn.projetreseauspring.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mn.projetreseauspring.entity.Utilisateur;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthentificationFilter extends UsernamePasswordAuthenticationFilter {
	private final AuthenticationManager authenticationManager;

	public JWTAuthentificationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		LoginModel loginModel = null;
		try {
			loginModel = new ObjectMapper().readValue(request.getInputStream(), LoginModel.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				Objects.requireNonNull(loginModel).getUsername(), Objects.requireNonNull(loginModel).getPassword(),
				Collections.emptyList());
		return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		Utilisateur utilisateur = (Utilisateur) authResult.getPrincipal();
		Collection<? extends GrantedAuthority> authorities = utilisateur.getAuthorities();
		String role = authorities.toArray()[0].toString();
		Date dateExpiration = new Date(System.currentTimeMillis() + SecurityProperties.EXPIRES_IN);
		String token = JWT.create().withSubject(utilisateur.getLogin()).withExpiresAt(dateExpiration)
				.withClaim("role", role).withIssuedAt(new Date()).sign(Algorithm.HMAC512(SecurityProperties.SECRET));
		response.addHeader(HttpHeaders.AUTHORIZATION, token);
	}

}
