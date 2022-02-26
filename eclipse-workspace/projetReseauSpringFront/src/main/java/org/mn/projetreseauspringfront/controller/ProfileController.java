package org.mn.projetreseauspringfront.controller;


import lombok.RequiredArgsConstructor;

import org.mn.projetreseauspringfront.dto.MessageDTO;
import org.mn.projetreseauspringfront.dto.UtilisateurDTO;
import org.mn.projetreseauspringfront.service.EnvoyerDemandeService;
import org.mn.projetreseauspringfront.service.MessageService;
import org.mn.projetreseauspringfront.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

import static org.mn.projetreseauspringfront.utils.ServerUtils.getUtilisateurFromSession;

@Controller
@RequestMapping("/api/secured/utilisateur")
@RequiredArgsConstructor
public class ProfileController {

    private final UtilisateurService utilisateurService;
    private final EnvoyerDemandeService envoyerDemandeService;
    private final MessageService messageService;

    public ProfileController(UtilisateurService utilisateurService, EnvoyerDemandeService envoyerDemandeService,
			MessageService messageService) {
		this.utilisateurService = utilisateurService;
		this.envoyerDemandeService = envoyerDemandeService;
		this.messageService = messageService;
	}

	public ProfileController() {
		this.utilisateurService = null;
		this.envoyerDemandeService = null;
		this.messageService = null;
	}

	@GetMapping("/profile")
    public String getProfilePage(Model model, HttpServletRequest request) {
        UtilisateurDTO utilisateur = getUtilisateurFromSession(request);
        model.addAttribute("utilisateur", utilisateur);
        MessageDTO recentMessage = messageService.getRecentMessage(utilisateur.getId());
        model.addAttribute("recentMessage", recentMessage);
        Set<UtilisateurDTO> envoyerDemande = envoyerDemandeService.getAcceptedEnvoyerDemandehipUtilisateurs(utilisateur.getId());
        model.addAttribute("envoyerDemande", envoyerDemande);
        return "profile";
    }

    @GetMapping("/profile/{id}")
    public String getUtilisateurPage(@PathVariable Long id, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        UtilisateurDTO sessionUtilisateur = getUtilisateurFromSession(request);
        if(sessionUtilisateur.getId().equals(id)) {
            return "redirect:/utilisateur/profile";
        }
        UtilisateurDTO utilisateur = utilisateurService.getUtilisateurById(id);
        Set<UtilisateurDTO> envoyerDemande = envoyerDemandeService.getAcceptedEnvoyerDemandehipUtilisateurs(id);
        Boolean envoyerDemandehip = envoyerDemandeService.checkEnvoyerDemandehip(sessionUtilisateur, utilisateur);
        model.addAttribute("utilisateur", utilisateur);
        model.addAttribute("utilisateursHaveEnvoyerDemandehip", envoyerDemandehip);
        model.addAttribute("envoyerDemande", envoyerDemande);
        return "profile";
    }
}
