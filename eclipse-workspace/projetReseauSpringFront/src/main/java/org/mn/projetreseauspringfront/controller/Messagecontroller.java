package org.mn.projetreseauspringfront.controller;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.mn.projetreseauspringfront.dto.MessageDTO;
import org.mn.projetreseauspringfront.dto.UtilisateurDTO;
import org.mn.projetreseauspringfront.service.MessageService;
import org.mn.projetreseauspringfront.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import static org.mn.projetreseauspringfront.utils.ServerUtils.getUtilisateurFromSession;


@Controller
@RequestMapping("/api/secured/utilisateur")
@RequiredArgsConstructor
public class Messagecontroller {

    private final MessageService messageService;
    private final UtilisateurService utilisateurService;
    

    public Messagecontroller(MessageService messageService, UtilisateurService utilisateurService) {
		this.messageService = messageService;
		this.utilisateurService = utilisateurService;
	}

	private void addConversationToModel(Long companionId, HttpServletRequest request, Model model) {
        UtilisateurDTO utilisateur = getUtilisateurFromSession(request);
        UtilisateurDTO companion = utilisateurService.getUtilisateurById(companionId);
        List<MessageDTO> message = messageService.findConversation(utilisateur.getId(), companionId);
        model.addAttribute("message", message);
        model.addAttribute("companion", companion);
    }

    @GetMapping("/message")
    public String getMessages(HttpServletRequest request, Model model) {
        UtilisateurDTO utilisateur = getUtilisateurFromSession(request);
        Collection<MessageDTO> recentMessages = messageService.findAllRecentMessages(utilisateur.getId());
        model.addAttribute("recentMessages", recentMessages);
        return "message";
    }

    @GetMapping("/conversation/{companionId}")
    public String getConversation(@PathVariable Long companionId, HttpServletRequest request, Model model) {
        addConversationToModel(companionId, request, model);
        model.addAttribute("newMessage", new MessageDTO());
        return "conversation";
    }

    @PostMapping("/conversation/{companionId}")
    public String postMessage(@PathVariable Long companionId,
                              @Valid @ModelAttribute("newMessage") MessageDTO messageDTO, BindingResult bindingResult,
                              HttpServletRequest request, Model model) {
        if(bindingResult.hasErrors()) {
            addConversationToModel(companionId, request, model);
            return "conversation";
        }
        UtilisateurDTO utilisateur = getUtilisateurFromSession(request);
        UtilisateurDTO companion = utilisateurService.getUtilisateurById(companionId);
        messageDTO.setExpediteur(utilisateur);
        messageDTO.setDestinataire(companion);
        messageDTO.setDateEnvoi(LocalDateTime.now());
        messageService.postMessage(messageDTO);
        return "redirect:/utilisateur/conversation/" + messageDTO.getDestinataire().getId();
    }

}
