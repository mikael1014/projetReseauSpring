package org.mn.projetreseauspring.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

//EnvoyerMessage
@Entity
//@Table(name = "envoyer_message")
public class Message extends BaseEntity {

	private String contenu;

	@Column(name = "dateEnvoi")
	private LocalDateTime dateEnvoi;

	private boolean lu = false;
	@ManyToOne
	@JoinColumn // (name = "listeMessagesEnvoyes")
	private Utilisateur expediteur;

	@ManyToOne
	@JoinColumn // (name = "ListeMessagesRecus")
	private Utilisateur destinataire;

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public LocalDateTime getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(LocalDateTime dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public boolean isLu() {
		return lu;
	}

	public void setLu(boolean lu) {
		this.lu = lu;
	}

	public Utilisateur getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(Utilisateur expediteur) {
		this.expediteur = expediteur;
	}

	public Utilisateur getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Utilisateur destinataire) {
		this.destinataire = destinataire;
	}

	public Message(String contenu, LocalDateTime dateEnvoi, boolean lu, Utilisateur expediteur, Utilisateur destinataire) {
		this.contenu = contenu;
		this.dateEnvoi = dateEnvoi;
		this.lu = lu;
		this.expediteur = expediteur;
		this.destinataire = destinataire;
	}

	public Message() {
	}

	public Message(String contenu, Utilisateur expediteur, Utilisateur destinataire) {
		this.contenu = contenu;
		this.expediteur = expediteur;
		this.destinataire = destinataire;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [contenu=");
		builder.append(contenu);
		builder.append(", dateEnvoi=");
		builder.append(dateEnvoi);
		builder.append(", lu=");
		builder.append(lu);
		builder.append(", expediteur=");
		builder.append(expediteur);
		builder.append(", destinataire=");
		builder.append(destinataire);
		builder.append("]");
		return builder.toString();
	}

}
