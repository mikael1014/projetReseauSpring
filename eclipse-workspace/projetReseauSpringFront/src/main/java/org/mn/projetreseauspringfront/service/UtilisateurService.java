package org.mn.projetreseauspringfront.service;

import java.util.List;

import org.mn.projetreseauspringfront.dto.PageDTO;
import org.mn.projetreseauspringfront.dto.UtilisateurDTO;
import org.mn.projetreseauspringfront.model.Utilisateur;
import org.springframework.data.domain.Pageable;



/**
 *
 * @author Mike
 */
public interface UtilisateurService {
	Utilisateur getById(long id);

	List<Utilisateur> lister();

	String ajouter(Utilisateur utilisateur);
	
	Utilisateur getUtilisateur(Long id);

    UtilisateurDTO getUtilisateurById(Long id);

    UtilisateurDTO getUtilisateurByEmail(String email);

    PageDTO<UtilisateurDTO> findAllPageable(Long id, Pageable pageable);

    PageDTO<UtilisateurDTO> findAllWithSearch(Long id, String search, Pageable pageable);

    void createUtilisateur(UtilisateurDTO utilisateurDTO);

    void updatePassword(String password, Long id);

    void updateUtilisateur(UtilisateurDTO utilisateurDTO);

    void updateUtilisateurImage(UtilisateurDTO utilisateurDTO, String fileName);

    void makeUtilisateurAdmin(Long utilisateurId);

    void blockUtilisateur(Long utilisateurId);

	UtilisateurDTO getUtilisateurByLogin(String email);

	
}
