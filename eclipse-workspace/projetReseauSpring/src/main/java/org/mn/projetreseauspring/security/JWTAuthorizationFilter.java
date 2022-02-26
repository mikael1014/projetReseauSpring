package org.mn.projetreseauspring.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String headerToken = request.getHeader(HttpHeaders.AUTHORIZATION);

		if (headerToken != null && !headerToken.isEmpty()) {
			String token = headerToken.replace("Bearer ", "");

			try {
				DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(SecurityProperties.SECRET)).build().verify(token);
				String username = decodedJWT.getSubject();
				String role = decodedJWT.getClaim("role").asString();
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
						new UsernamePasswordAuthenticationToken(username,null, Collections.singletonList(authority));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			} catch (Exception exception) {
				System.out.println("Jeton invalide");
				exception.printStackTrace();
			}

		}
		chain.doFilter(request, response);
	}
}