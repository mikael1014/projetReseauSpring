package org.mn.projetreseauspringfront.controller;

import lombok.RequiredArgsConstructor;

import org.mn.projetreseauspringfront.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/secured/utilisateur/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UtilisateurService utilisateurService;

    public AdminController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@PostMapping("/makeAdmin")
    public String makeAdmin(@RequestParam Long utilisateurId, HttpServletRequest request) {
        utilisateurService.makeUtilisateurAdmin(utilisateurId);
        return "redirect:/utilisateur/profile/" + utilisateurId;
    }

    @PostMapping("/block")
    public String blockUtilisateur(@RequestParam Long utilisateurId, HttpServletRequest request) {
        utilisateurService.blockUtilisateur(utilisateurId);
        return "redirect:/utilisateur/profile/" + utilisateurId;
    }

}
