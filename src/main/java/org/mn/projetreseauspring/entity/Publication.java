package org.mn.projetreseauspring.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.mn.projetreseauspring.entiy.enum_.Visibilite;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Publication extends BaseEntity {

	@Enumerated(EnumType.STRING)
	private Visibilite visibilite;

	@Column(nullable = false)
	private String texte;

	@ManyToOne
	private Utilisateur utilisateur;

	@OneToMany(mappedBy = "publication")
	private List<Reagir> reagir;

	@OneToMany(mappedBy = "publication")
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
