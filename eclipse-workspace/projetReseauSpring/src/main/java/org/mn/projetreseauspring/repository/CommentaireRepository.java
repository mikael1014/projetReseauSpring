package org.mn.projetreseauspring.repository;

import java.util.List;

import org.mn.projetreseauspring.entity.Commentaire;
import org.mn.projetreseauspring.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository  extends JpaRepository<Commentaire, Long> {


	List<Commentaire> findAllByTexte(String query);

	List<Commentaire> findByUtilisateur(Utilisateur utilisateur);
}
