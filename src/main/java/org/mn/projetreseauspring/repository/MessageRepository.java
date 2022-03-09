package org.mn.projetreseauspring.repository;

import java.util.List;
import org.mn.projetreseauspring.entity.Message;
import org.mn.projetreseauspring.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
	List<Message> findByContenu(String contenu);

	List<Message> findByDestinataire(Utilisateur destinataire);
	
	List<Message> findByExpediteur(Utilisateur expediteur);

	List<Message> findAllByContenu(String query);

}