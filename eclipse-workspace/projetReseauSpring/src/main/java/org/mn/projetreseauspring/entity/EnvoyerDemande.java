package org.mn.projetreseauspring.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.mn.projetreseauspring.entiy.enum_.Etat;

//EnvoyerDemande

@Entity
//@Table(name = "envoyer_demande")
public class EnvoyerDemande extends BaseEntity {

	@Enumerated(EnumType.STRING)
	private Etat etat;

	@ManyToOne(optional = false)
	@JoinColumn(name = "utilisateur_expediteur")
	private Utilisateur utilisateurExpediteur;

	@ManyToOne(optional = false)
	@JoinColumn(name = "utilisateur_destinataire")
	private Utilisateur utilisateurDestinataire;

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Utilisateur getUtilisateurExpediteur() {
		return utilisateurExpediteur;
	}

	public void setUtilisateurExpediteur(Utilisateur utilisateurExpediteur) {
		this.utilisateurExpediteur = utilisateurExpediteur;
	}

	public Utilisateur getUtilisateurDestinataire() {
		return utilisateurDestinataire;
	}

	public void setUtilisateurDestinataire(Utilisateur utilisateurDestinataire) {
		this.utilisateurDestinataire = utilisateurDestinataire;
	}

	public EnvoyerDemande(Etat etat, Utilisateur utilisateurExpediteur, Utilisateur utilisateurDestinataire) {
		this.etat = etat;
		this.utilisateurExpediteur = utilisateurExpediteur;
		this.utilisateurDestinataire = utilisateurDestinataire;
	}

	public EnvoyerDemande() {
	}
	
	

	public EnvoyerDemande(Utilisateur utilisateurExpediteur, Utilisateur utilisateurDestinataire) {
		this.utilisateurExpediteur = utilisateurExpediteur;
		this.utilisateurDestinataire = utilisateurDestinataire;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EnvoyerDemande []");
		return builder.toString();
	}

}
