package org.mn.projetreseauspringfront.model;

import java.util.Date;
import java.util.List;

import org.mn.projetreseauspringfront.entiy.enum_.CategorieEpreuve;
import org.mn.projetreseauspringfront.entiy.enum_.Visibilite;




public class PublicationEpreuve extends Publication {

	private String lien;

	private Date datePassage;

	private CategorieEpreuve categorieEpreuve;

	private String classe;

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public Date getDatePassage() {
		return datePassage;
	}

	public void setDatePassage(Date datePassage) {
		this.datePassage = datePassage;
	}

	public CategorieEpreuve getCategorieEpreuve() {
		return categorieEpreuve;
	}

	public void setCategorieEpreuve(CategorieEpreuve categorieEpreuve) {
		this.categorieEpreuve = categorieEpreuve;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public PublicationEpreuve(Visibilite visibilite, String texte, Utilisateur utilisateur, List<Reagir> reagir,
			List<Commentaire> commentaires, String lien, Date datePassage, CategorieEpreuve categorieEpreuve,
			String classe) {
		super(visibilite, texte, utilisateur, reagir, commentaires);
		this.lien = lien;
		this.datePassage = datePassage;
		this.categorieEpreuve = categorieEpreuve;
		this.classe = classe;
	}

	public PublicationEpreuve(Visibilite visibilite, String texte, Utilisateur utilisateur, List<Reagir> reagir,
			List<Commentaire> commentaires) {
		super(visibilite, texte, utilisateur, reagir, commentaires);
	}
	
	public PublicationEpreuve() {
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PublicationEpreuve [lien=");
		builder.append(lien);
		builder.append(", datePassage=");
		builder.append(datePassage);
		builder.append(", categorieEpreuve=");
		builder.append(categorieEpreuve);
		builder.append(", classe=");
		builder.append(classe);
		builder.append("]");
		return builder.toString();
	}
	

}
