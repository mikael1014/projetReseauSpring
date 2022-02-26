package org.mn.projetreseauspring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import org.mn.projetreseauspring.entiy.enum_.Like;

@Entity
public class Reagir extends BaseEntity {

	@Enumerated(EnumType.STRING)
	@Column( nullable = false)
	private Like aimer;

	@ManyToOne(optional = false)
	private Publication publication;

	@ManyToOne
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
