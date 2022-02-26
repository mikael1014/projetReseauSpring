package org.mn.projetreseauspring.security;

import org.mn.projetreseauspring.entity.Commentaire;
import org.mn.projetreseauspring.entity.EnvoyerDemande;
import org.mn.projetreseauspring.entity.Groupe;
import org.mn.projetreseauspring.entity.Message;
import org.mn.projetreseauspring.entity.Publication;
import org.mn.projetreseauspring.entity.Reagir;
import org.mn.projetreseauspring.entity.Utilisateur;
import org.mn.projetreseauspring.entiy.enum_.Like;
import org.mn.projetreseauspring.entiy.enum_.RoleAdherent;
import org.mn.projetreseauspring.entiy.enum_.RoleUtilisateur;
import org.mn.projetreseauspring.repository.CommentaireRepository;
import org.mn.projetreseauspring.repository.EnvoyerDemandeRepository;
import org.mn.projetreseauspring.repository.GroupeRepository;
import org.mn.projetreseauspring.repository.MessageRepository;
import org.mn.projetreseauspring.repository.PublicationRepository;
import org.mn.projetreseauspring.repository.ReagirRepository;
import org.mn.projetreseauspring.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {

	private final UtilisateurRepository utilisateurRepository;
	private final PasswordEncoder passwordEncoder;
	private final MessageRepository messageRepository;
	private final PublicationRepository publicationRepository;
	private final CommentaireRepository commentaireRepository;
	private final ReagirRepository reagirRepository;
	private final EnvoyerDemandeRepository envoyerDemandeRepository;
	private final GroupeRepository groupeRepository;

	public DbInit(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder,
			MessageRepository messageRepository, PublicationRepository publicationRepository,
			CommentaireRepository commentaireRepository, ReagirRepository reagirRepository, EnvoyerDemandeRepository envoyerDemandeRepository, GroupeRepository groupeRepository) {
		this.utilisateurRepository = utilisateurRepository;
		this.passwordEncoder = passwordEncoder;
		this.messageRepository = messageRepository;
		this.publicationRepository = publicationRepository;
		this.commentaireRepository = commentaireRepository;
		this.reagirRepository = reagirRepository;
		this.envoyerDemandeRepository = envoyerDemandeRepository;
		this.groupeRepository = groupeRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * // inscription Admin et User de base
		 * 
		 * Utilisateur user1 = new Utilisateur("user1", passwordEncoder.encode("123"),
		 * RoleUtilisateur.USER); Utilisateur admin1 = new Utilisateur("admin1",
		 * passwordEncoder.encode("1234"), RoleUtilisateur.ADMIN);
		 * utilisateurRepository.save(user1); utilisateurRepository.save(admin1);
		 * 
		 * // message entre users
		 * 
		 * Utilisateur expediteur1 = new Utilisateur("expediteur1",
		 * passwordEncoder.encode("123"), RoleUtilisateur.USER); Utilisateur
		 * destinateur1 = new Utilisateur("destinateur1", passwordEncoder.encode("123"),
		 * RoleUtilisateur.USER); Utilisateur expediteur2 = new
		 * Utilisateur("expediteur2", passwordEncoder.encode("123"),
		 * RoleUtilisateur.USER); Utilisateur destinateur2 = new
		 * Utilisateur("destinateur2", passwordEncoder.encode("123"),
		 * RoleUtilisateur.USER); Message message1 = new Message("contenu1",
		 * expediteur1, destinateur1); Message message2 = new Message("contenu2",
		 * expediteur2, destinateur2); utilisateurRepository.save(expediteur1);
		 * utilisateurRepository.save(expediteur2);
		 * utilisateurRepository.save(destinateur1);
		 * utilisateurRepository.save(destinateur2); messageRepository.save(message1);
		 * messageRepository.save(message2);
		 * 
		 * // Publication (reaction et commentaire)
		 * 
		 * Utilisateur commentateur1 = new Utilisateur("commentateur1",
		 * passwordEncoder.encode("123"), RoleUtilisateur.USER); Utilisateur
		 * commentateur2 = new Utilisateur("commentateur2",
		 * passwordEncoder.encode("1234"), RoleUtilisateur.USER); Publication
		 * publication1 = new Publication("publication1"); Publication publication2 =
		 * new Publication("publication2"); Publication publication3 = new
		 * Publication("publication3"); Commentaire commentaire1 = new
		 * Commentaire("commentaire1"); Commentaire commentaire2 = new
		 * Commentaire("commentaire2"); Reagir reagir1 = new Reagir(Like.AIMER,
		 * publication1); Reagir reagir2 = new Reagir(Like.DETESTER, publication2);
		 * Reagir reagir3 = new Reagir(Like.ADORER, publication3);
		 * 
		 * utilisateurRepository.save(commentateur1);
		 * utilisateurRepository.save(commentateur2);
		 * publicationRepository.save(publication1);
		 * publicationRepository.save(publication2);
		 * publicationRepository.save(publication3);
		 * commentaireRepository.save(commentaire1);
		 * commentaireRepository.save(commentaire2); reagirRepository.save(reagir1);
		 * reagirRepository.save(reagir2); reagirRepository.save(reagir3);
		 * 
		 * // Demande d'amitié
		 * 
		 * Utilisateur expediteuramitie1 = new Utilisateur("expediteuramitie1",
		 * passwordEncoder.encode("123"), RoleUtilisateur.USER); Utilisateur
		 * destinateuramitie1 = new Utilisateur("destinateuramitie1",
		 * passwordEncoder.encode("123"), RoleUtilisateur.USER); Utilisateur
		 * expediteuramitie2 = new Utilisateur("expediteuramitie2",
		 * passwordEncoder.encode("123"), RoleUtilisateur.USER); Utilisateur
		 * destinateuramitie2 = new Utilisateur("destinateuramitie2",
		 * passwordEncoder.encode("123"), RoleUtilisateur.USER);
		 * 
		 * EnvoyerDemande envoyerDemande1 = new
		 * EnvoyerDemande(expediteuramitie1,destinateuramitie1); EnvoyerDemande
		 * envoyerDemande2 = new EnvoyerDemande(expediteuramitie2,destinateuramitie2);
		 * 
		 * utilisateurRepository.save(expediteuramitie1);
		 * utilisateurRepository.save(expediteuramitie2);
		 * utilisateurRepository.save(destinateuramitie1);
		 * utilisateurRepository.save(destinateuramitie2);
		 * envoyerDemandeRepository.save(envoyerDemande1);
		 * envoyerDemandeRepository.save(envoyerDemande2);
		 * 
		 * 
		 * // Groupe adesion et administration
		 * 
		 * 
		 * 
		 * Utilisateur adherent1 = new Utilisateur("adherent1",
		 * passwordEncoder.encode("123"), RoleUtilisateur.USER); Utilisateur adherent2 =
		 * new Utilisateur("adherent2", passwordEncoder.encode("123"),
		 * RoleUtilisateur.USER); Utilisateur adherent3 = new Utilisateur("adherent3",
		 * passwordEncoder.encode("123"), RoleUtilisateur.USER); Utilisateur adherent4 =
		 * new Utilisateur("adherent4", passwordEncoder.encode("1234"),
		 * RoleUtilisateur.ADMIN); Utilisateur admingroupe1 = new
		 * Utilisateur("admingroupe1", passwordEncoder.encode("1234"),
		 * RoleUtilisateur.ADMIN); Utilisateur admingroupe2 = new
		 * Utilisateur("admingroupe2", passwordEncoder.encode("1234"),
		 * RoleUtilisateur.USER);
		 * 
		 * utilisateurRepository.save(adherent1); utilisateurRepository.save(adherent2);
		 * utilisateurRepository.save(adherent3); utilisateurRepository.save(adherent4);
		 * utilisateurRepository.save(admingroupe1);
		 * utilisateurRepository.save(admingroupe2);
		 * 
		 * Groupe groupe1 = new Groupe("groupe1",adherent1,RoleAdherent.USER); Groupe
		 * groupe2 = new Groupe("groupe2",admingroupe1,RoleAdherent.ADMIN); Groupe
		 * groupe3 = new Groupe("groupe3",adherent1,RoleAdherent.MODO); Groupe groupe4 =
		 * new Groupe("groupe4",admingroupe1,RoleAdherent.ADMIN); Groupe groupe5 = new
		 * Groupe("groupe5",adherent1,RoleAdherent.USER); Groupe groupe6 = new
		 * Groupe("groupe6",admingroupe1,RoleAdherent.ADMIN);
		 * 
		 * 
		 * groupeRepository.save(groupe1); groupeRepository.save(groupe2);
		 * groupeRepository.save(groupe3); groupeRepository.save(groupe4);
		 * groupeRepository.save(groupe5); groupeRepository.save(groupe6);
		 */
		  
		 

	}

}
