package org.mn.projetreseauspring.service;

import org.mn.projetreseauspring.dto.UtilisateurDTO;
import org.mn.projetreseauspring.entity.Utilisateur;
import org.mn.projetreseauspring.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
//import java.util.UUID;

@Service
@Transactional
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
       
        return utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> findAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur findUtilisateurById(Long id) {
        return utilisateurRepository.findUtilisateurById(id);
  //                  .orElseThrow(() -> new UserNotFoundException("Utilisateur ayant id " + id + " introuvable"));
    }

    public void deleteUtilisateur(Long id){
        utilisateurRepository.deleteUtilisateurById(id);
    }

	public Utilisateur getUtilisateurByLogin(String login) {
		return utilisateurRepository.findUtilisateurBylogin(login);
	}
	
}
