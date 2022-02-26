package org.mn.projetreseauspringfront.controller;


import lombok.RequiredArgsConstructor;

import org.mn.projetreseauspringfront.dto.UtilisateurDTO;
import org.mn.projetreseauspringfront.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UtilisateurService utilisateurService;

    public IndexController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@GetMapping("/")
    public String indexPage(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        if (request.getSession().getAttribute("utilisateur") != null) {
            response.sendRedirect(request.getContextPath() + "/utilisateur/profile");
            return null;
        }
        model.addAttribute("utilisateur", new UtilisateurDTO());
        return "index";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "service/access-denied";
    }

    @PostMapping("/register")
    public String registerUtilisateur(@Valid @ModelAttribute("utilisateur") UtilisateurDTO utilisateurDTO, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }

        String email = utilisateurDTO.getLogin();
        UtilisateurDTO utilisateurByLogin = utilisateurService.getUtilisateurByLogin(email);
        if (utilisateurByLogin != null) {
            model.addAttribute("registrationError", true);
            model.addAttribute("utilisateur", utilisateurDTO);
            return "index";
        }
        utilisateurService.createUtilisateur(utilisateurDTO);
        return "service/registration-confirmation";
    }

}
