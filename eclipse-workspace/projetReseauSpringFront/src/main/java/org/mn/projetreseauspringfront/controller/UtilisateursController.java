package org.mn.projetreseauspringfront.controller;


import javax.servlet.http.HttpServletRequest;

import org.mn.projetreseauspringfront.dto.PageDTO;
import org.mn.projetreseauspringfront.dto.UtilisateurDTO;
import org.mn.projetreseauspringfront.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

import static org.mn.projetreseauspringfront.utils.ServerUtils.getUtilisateurFromSession;

/**
 *
 * @author Mike
 */

@Controller
@RequestMapping("/api/secured/utilisateur")
@RequiredArgsConstructor
public class UtilisateursController {
    
    
	

    @Value("${default.page.size}")
    private Integer defaultPageSize;

    private final UtilisateurService utilisateurService;

    public UtilisateursController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@GetMapping("/utilisateurs")
    public String getUtilisateurList(HttpServletRequest request,
                              @RequestParam(value = "search", required = false) String search,
                              @RequestParam(value = "page", required = false) Integer page,
                              Model model) {
    	UtilisateurDTO utilisateur = getUtilisateurFromSession(request);
        if (page == null)
            page = 0;

        PageRequest pageRequest = PageRequest.of(page, defaultPageSize, Sort.by("nom").and(Sort.by("prenom")));
        PageDTO<UtilisateurDTO> allPageable;
        if (StringUtils.isEmpty(search)) {
            allPageable = utilisateurService.findAllPageable(utilisateur.getId(), pageRequest);
        } else {
            allPageable = utilisateurService.findAllWithSearch(utilisateur.getId(), search, pageRequest);
        }
        model.addAttribute("page", allPageable);
        model.addAttribute("search", search);
        return "utilisateurs";
    }
}
