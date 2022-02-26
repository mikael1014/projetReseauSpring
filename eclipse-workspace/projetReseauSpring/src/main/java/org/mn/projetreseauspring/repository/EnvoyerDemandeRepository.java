package org.mn.projetreseauspring.repository;

import java.util.List;

import org.mn.projetreseauspring.entity.EnvoyerDemande;
import org.mn.projetreseauspring.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvoyerDemandeRepository   extends JpaRepository<EnvoyerDemande, Long>{

	List<EnvoyerDemande> findAllByEtat(String query);
	List<EnvoyerDemande> findByUtilisateurDestinataire(Utilisateur utilisateurDestinataire);
	List<EnvoyerDemande> findByUtilisateurExpediteur(Utilisateur utilisateurExpediteur);

}
