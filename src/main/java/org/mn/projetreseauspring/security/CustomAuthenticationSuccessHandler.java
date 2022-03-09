package org.mn.projetreseauspring.security;


import lombok.RequiredArgsConstructor;

import org.mn.projetreseauspring.entity.Utilisateur;
import org.mn.projetreseauspring.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
//@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final UtilisateurService utilisateurService;
	
	public CustomAuthenticationSuccessHandler(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {

		Utilisateur utilisateurDTO = utilisateurService.getUtilisateurByLogin(authentication.getName());
		request.getSession().setAttribute("utilisateur", utilisateurDTO);

		response.sendRedirect(request.getContextPath() + "/utilisateur/profile");
	}

}
