package org.mn.projetreseauspringfront.model;

import org.mn.projetreseauspringfront.entiy.enum_.Like;
import org.mn.projetreseauspringfront.service.BaseEntity;

public class Reagir extends BaseEntity {

	
	private Like aimer;

	
	private Publication publication;

	private Utilisateur utilisateur;

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Like getAimer() {
		return aimer;
	}

	public void setAimer(Like aimer) {
		this.aimer = aimer;
	}

	public Reagir() {
	}

	
	public Reagir(Like aimer, Publication publication, Utilisateur utilisateur) {
		this.aimer = aimer;
		this.publication = publication;
		this.utilisateur = utilisateur;
	}
	
	

	public Reagir(Like aimer, Publication publication) {
		this.aimer = aimer;
		this.publication = publication;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reagir [aimer=");
		builder.append(aimer);
		builder.append(", publication=");
		builder.append(publication);
		builder.append(", utilisateur=");
		builder.append(utilisateur);
		builder.append("]");
		return builder.toString();
	}

}
