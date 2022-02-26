package org.mn.projetreseauspring.repository;

import java.util.List;

import org.mn.projetreseauspring.entity.Commentaire;
import org.mn.projetreseauspring.entity.Publication;
import org.mn.projetreseauspring.entity.Reagir;
import org.mn.projetreseauspring.entity.Utilisateur;
import org.mn.projetreseauspring.entiy.enum_.Visibilite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication, Long> {


	List<Publication> findByUtilisateur(Utilisateur utilisateur);

//	List<Publication> findByReagir(List<Reagir> reagir);

//	List<Publication> findByCommentaires(List<Commentaire> commentaires);

	List<Publication> findByVisibilite(Visibilite visibilite);

	List<Publication> findAllByTexte(String query);
	
}
