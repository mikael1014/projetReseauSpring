package org.mn.projetreseauspringfront.model;

import java.time.LocalDateTime;

import org.mn.projetreseauspringfront.service.BaseEntity;


public class Message extends BaseEntity {

	private String contenu;

	private LocalDateTime dateEnvoi;

	private boolean lu = false;
	
	private Utilisateur expediteur;

	
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

	

}
