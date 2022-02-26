package org.mn.projetreseauspringfront.model;

import java.util.ArrayList;
import java.util.List;

import org.mn.projetreseauspringfront.entiy.enum_.RoleAdherent;
import org.mn.projetreseauspringfront.service.BaseEntity;





public class Groupe extends BaseEntity {

	private String libelle;

	private String description;


	private RoleAdherent roleAdherent;

	private List<Utilisateur> adherents = new ArrayList<>();

	private Utilisateur adherent;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public RoleUtilisateur getRoleUtilisateur() {
//		return roleUtilisateur;
//	}
//
//	public void setRoleUtilisateur(RoleUtilisateur roleUtilisateur) {
//		this.roleUtilisateur = roleUtilisateur;
//	}

	public List<Utilisateur> getAdherents() {
		return adherents;
	}

	public void setAdherents(List<Utilisateur> adherents) {
		this.adherents = adherents;
	}

//	public Utilisateur getUtilisateurAdministrateur() {
//		return administrateurGroupe;
//	}
//
//	public void setUtilisateurAdministrateur(Utilisateur utilisateurAdministrateur) {
//		this.administrateurGroupe = utilisateurAdministrateur;
//	}
//
//	public Groupe(String libelle, String description, RoleUtilisateur roleUtilisateur, List<Utilisateur> adherents,
//			Utilisateur utilisateurAdministrateur) {
//		this.libelle = libelle;
//		this.description = description;
//		this.roleUtilisateur = roleUtilisateur;
//		this.adherents = adherents;
//		this.administrateurGroupe = utilisateurAdministrateur;
//	}

	public RoleAdherent getRoleAdherent() {
		return roleAdherent;
	}

	public Utilisateur getAdherent() {
		return adherent;
	}

	public void setAdherent(Utilisateur adherent) {
		this.adherent = adherent;
	}

	public void setRoleAdherent(RoleAdherent roleAdherent) {
		this.roleAdherent = roleAdherent;
	}

	public Groupe() {
	}

	public Groupe(String libelle) {
		this.libelle = libelle;
	}
	
	

	public Groupe(String libelle, Utilisateur adherent) {
		this.libelle = libelle;
		this.adherent = adherent;
	}

	public Groupe(String libelle, Utilisateur adherent, RoleAdherent roleAdherent) {
		this.libelle = libelle;
		this.adherent = adherent;
		this.roleAdherent = roleAdherent;
	}

	public Groupe(String libelle, String description, RoleAdherent roleAdherent, List<Utilisateur> adherents) {
		this.libelle = libelle;
		this.description = description;
		this.roleAdherent = roleAdherent;
		this.adherents = adherents;
	}

	public Groupe(String libelle, String description, RoleAdherent roleAdherent, List<Utilisateur> adherents,
			Utilisateur adherent) {
		this.libelle = libelle;
		this.description = description;
		this.roleAdherent = roleAdherent;
		this.adherents = adherents;
		this.adherent = adherent;
	}

}
