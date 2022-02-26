package org.mn.projetreseauspringfront.model;

import java.util.List;

import org.mn.projetreseauspringfront.entiy.enum_.Visibilite;
import org.mn.projetreseauspringfront.service.BaseEntity;


public class Publication extends BaseEntity {

	private Visibilite visibilite;

	private String texte;

	private Utilisateur utilisateur;

	private List<Reagir> reagir;

	private List<Commentaire> commentaires;

	public Visibilite getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(Visibilite visibilite) {
		this.visibilite = visibilite;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Reagir> getReagir() {
		return reagir;
	}

	public void setReagir(List<Reagir> reagir) {
		this.reagir = reagir;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Publication(Visibilite visibilite, String texte, Utilisateur utilisateur, List<Reagir> reagir,
			List<Commentaire> commentaires) {
		this.visibilite = visibilite;
		this.texte = texte;
		this.utilisateur = utilisateur;
		this.reagir = reagir;
		this.commentaires = commentaires;
	}

	public Publication(String texte) {
		this.texte = texte;
	}

	public Publication() {
	}

	public Publication(List<Reagir> reagir) {
		this.reagir = reagir;
	}

	public Publication(String texte, Utilisateur utilisateur) {
		this.texte = texte;
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Publication [visibilite=");
		builder.append(visibilite);
		builder.append(", texte=");
		builder.append(texte);
		builder.append(", utilisateur=");
		builder.append(utilisateur);
		builder.append(", reagir=");
		builder.append(reagir);
		builder.append(", commentaires=");
		builder.append(commentaires);
		builder.append("]");
		return builder.toString();
	}

}
