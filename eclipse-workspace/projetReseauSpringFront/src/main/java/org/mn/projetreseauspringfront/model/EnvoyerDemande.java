package org.mn.projetreseauspringfront.model;

import org.mn.projetreseauspringfront.entiy.enum_.Etat;
import org.mn.projetreseauspringfront.service.BaseEntity;

public class EnvoyerDemande extends BaseEntity {

	
	private Etat etat;

	
	private Utilisateur utilisateurExpediteur;


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
