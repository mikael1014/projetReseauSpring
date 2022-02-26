package org.mn.projetreseauspring.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire extends BaseEntity {

	private String texte;
	private String datePoster;
	
	@ManyToOne
	private Publication publication;
	
	@ManyToOne	
	private Utilisateur utilisateur;

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public String getDatePoster() {
		return datePoster;
	}

	public void setDatePoster(String datePoster) {
		this.datePoster = datePoster;
	}

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

	public Commentaire(String texte, String datePoster, Publication publication, Utilisateur utilisateur) {
		this.texte = texte;
		this.datePoster = datePoster;
		this.publication = publication;
		this.utilisateur = utilisateur;
	}

	public Commentaire() {
	}


	public Commentaire(String texte) {
		this.texte = texte;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Commentaire [texte=");
		builder.append(texte);
		builder.append(", datePoster=");
		builder.append(datePoster);
		builder.append(", publication=");
		builder.append(publication);
		builder.append(", utilisateur=");
		builder.append(utilisateur);
		builder.append("]");
		return builder.toString();
	}

	

}
