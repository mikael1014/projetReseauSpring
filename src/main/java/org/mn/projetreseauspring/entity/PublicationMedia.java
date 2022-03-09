package org.mn.projetreseauspring.entity;



import java.util.List;

import javax.persistence.Entity;

import org.mn.projetreseauspring.entiy.enum_.Visibilite;

@Entity
public class PublicationMedia extends Publication {

	private String referenceMedia;

	public String getReferenceMedia() {
		return referenceMedia;
	}

	public void setReferenceMedia(String referenceMedia) {
		this.referenceMedia = referenceMedia;
	}

	public PublicationMedia(Visibilite visibilite, String texte, Utilisateur utilisateur, List<Reagir> reagir,
			List<Commentaire> commentaires, String referenceMedia) {
		super(visibilite, texte, utilisateur, reagir, commentaires);
		this.referenceMedia = referenceMedia;
	}

	public PublicationMedia(Visibilite visibilite, String texte, Utilisateur utilisateur, List<Reagir> reagir,
			List<Commentaire> commentaires) {
		super(visibilite, texte, utilisateur, reagir, commentaires);
	}
	public PublicationMedia() {		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PublicationMedia [referenceMedia=");
		builder.append(referenceMedia);
		builder.append("]");
		return builder.toString();
	}
	
	

}
