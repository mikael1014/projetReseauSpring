package org.mn.projetreseauspringfront.controller;

import lombok.RequiredArgsConstructor;

import org.mn.projetreseauspringfront.dto.UtilisateurDTO;
import org.mn.projetreseauspringfront.service.EnvoyerDemandeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;

import static org.mn.projetreseauspringfront.utils.ServerUtils.getUtilisateurFromSession;

@Controller
@RequestMapping("/api/secured/utilisateur/envoyerDemande")
@RequiredArgsConstructor
public class EnvoyerDemandeController {

    private final EnvoyerDemandeService envoyerDemandeService;

    public EnvoyerDemandeController(EnvoyerDemandeService envoyerDemandeService) {
		this.envoyerDemandeService = envoyerDemandeService;
	}

	public EnvoyerDemandeController() {
		this.envoyerDemandeService = null;
	}

	@GetMapping
    public String getAllEnvoyerDemande(@RequestParam(value = "search", required = false) String search,
            Model model, HttpServletRequest request) {
        UtilisateurDTO utilisateur = getUtilisateurFromSession(request);
        Map<String, Set<UtilisateurDTO>> envoyerDemande = envoyerDemandeService.getEnvoyerDemande(utilisateur.getId(), search);
        model.addAttribute("utilisateursNotAcceptedRequests", envoyerDemande.get("utilisateursNotAcceptedRequests"));
        model.addAttribute("notAcceptedRequestsToUtilisateur", envoyerDemande.get("notAcceptedRequestsToUtilisateur"));
        model.addAttribute("envoyerDemandeOfUtilisateur", envoyerDemande.get("envoyerDemandeOfUtilisateur"));
        return "envoyerDemande";
    }

    @GetMapping("/{friendId}/decline")
    public String deleteEnvoyerDemande(@PathVariable Long friendId, HttpServletRequest request) {
        UtilisateurDTO utilisateur = getUtilisateurFromSession(request);
        envoyerDemandeService.deleteEnvoyerDemande(utilisateur, friendId);
        return "redirect:/utilisateur/envoyerDemande";
    }

    @GetMapping("/{friendId}/accept")
    public String acceptEnvoyerDemande(@PathVariable Long friendId, HttpServletRequest request) {
        UtilisateurDTO utilisateur = getUtilisateurFromSession(request);
        envoyerDemandeService.acceptEnvoyerDemande(utilisateur, friendId);
        return "redirect:/utilisateur/envoyerDemande";
    }

    @GetMapping("/{friendId}/addToEnvoyerDemande")
    public String addToEnvoyerDemande(@PathVariable Long friendId, HttpServletRequest request) {
        UtilisateurDTO utilisateur = getUtilisateurFromSession(request);
        envoyerDemandeService.addToEnvoyerDemande(utilisateur, friendId);
        return "redirect:/utilisateur/envoyerDemande";
    }

}
