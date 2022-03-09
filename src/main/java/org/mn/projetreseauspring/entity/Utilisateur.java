package org.mn.projetreseauspring.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.mn.projetreseauspring.entiy.enum_.RoleUtilisateur;
import org.mn.projetreseauspring.entiy.enum_.Sexe;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Mike
 */
@Entity
public class Utilisateur extends BaseEntity implements UserDetails {

//    @Column(name = "password")
	private String password;
	private String nom;
	private String prenom;
	@Enumerated(EnumType.STRING)
	private Sexe sexe;
	@Column(name = "email", unique = true, nullable = false) // si je garde l'email comme login
	private String login;
	@Enumerated(EnumType.STRING)
	private RoleUtilisateur roleUtilisateur;
	private String telephone;
	private String avatar;
	private String description;
	@Column(name = "date_de_naissance")
    private LocalDate ddn;
	@ManyToMany(mappedBy = "adherents")
	private List<Groupe> listeGroupes = new ArrayList<Groupe>();
	@JsonIgnore
	@OneToMany(mappedBy = "expediteur")
	private List<Message> listeMessagesEnvoyes = new ArrayList<Message>();
	@JsonIgnore
	@OneToMany(mappedBy = "destinataire")
	private List<Message> listeMessagesRecus = new ArrayList<Message>();
	@JsonIgnore
	@OneToMany(mappedBy = "utilisateur")
	private List<Publication> listePublications = new ArrayList<Publication>();
	@JsonIgnore
	@OneToMany(mappedBy = "utilisateur")
	private List<Commentaire> listeCommentaires = new ArrayList<Commentaire>();
	@JsonIgnore
	@OneToMany(mappedBy = "utilisateur")
	private List<Reagir> listeReagirs = new ArrayList<Reagir>();

	@ManyToMany
	@JoinColumn(referencedColumnName = "id")
	@JsonIgnore
	Collection<Utilisateur> demandeEncours = new ArrayList<>();

	@ManyToMany
	@JoinColumn(name = "demande", referencedColumnName = "id")
	@JsonIgnore
	Collection<Utilisateur> demandes = new ArrayList<>();

	public LocalDate getDdn() {
		return ddn;
	}

	public Utilisateur(String password, String nom, String prenom, Sexe sexe, String login,
			RoleUtilisateur roleUtilisateur, String telephone, String avatar, String description, LocalDate ddn,
			List<Groupe> listeGroupes, List<Message> listeMessagesEnvoyes, List<Message> listeMessagesRecus,
			List<Publication> listePublications, List<Commentaire> listeCommentaires, List<Reagir> listeReagirs,
			Collection<Utilisateur> demandeEncours, Collection<Utilisateur> demandes) {
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.login = login;
		this.roleUtilisateur = roleUtilisateur;
		this.telephone = telephone;
		this.avatar = avatar;
		this.description = description;
		this.ddn = ddn;
		this.listeGroupes = listeGroupes;
		this.listeMessagesEnvoyes = listeMessagesEnvoyes;
		this.listeMessagesRecus = listeMessagesRecus;
		this.listePublications = listePublications;
		this.listeCommentaires = listeCommentaires;
		this.listeReagirs = listeReagirs;
		this.demandeEncours = demandeEncours;
		this.demandes = demandes;
	}

	public void setDdn(LocalDate ddn) {
		this.ddn = ddn;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public RoleUtilisateur getRoleUtilisateur() {
		return roleUtilisateur;
	}

	public void setRoleUtilisateur(RoleUtilisateur roleUtilisateur) {
		this.roleUtilisateur = roleUtilisateur;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Groupe> getListeGroupes() {
		return listeGroupes;
	}

	public void setListeGroupes(List<Groupe> listeGroupes) {
		this.listeGroupes = listeGroupes;
	}

	public List<Message> getListeMessagesEnvoyes() {
		return listeMessagesEnvoyes;
	}

	public void setListeMessagesEnvoyes(List<Message> listeMessagesEnvoyes) {
		this.listeMessagesEnvoyes = listeMessagesEnvoyes;
	}

	public List<Message> getListeMessagesRecus() {
		return listeMessagesRecus;
	}

	public void setListeMessagesRecus(List<Message> listeMessagesRecus) {
		this.listeMessagesRecus = listeMessagesRecus;
	}

	public List<Publication> getListePublications() {
		return listePublications;
	}

	public void setListePublications(List<Publication> listePublications) {
		this.listePublications = listePublications;
	}

	public List<Commentaire> getListeCommentaires() {
		return listeCommentaires;
	}

	public void setListeCommentaires(List<Commentaire> listeCommentaires) {
		this.listeCommentaires = listeCommentaires;
	}

	public Collection<Utilisateur> getDemandeEncours() {
		return demandeEncours;
	}

	public void setDemandeEncours(Collection<Utilisateur> demandeEncours) {
		this.demandeEncours = demandeEncours;
	}

	public Collection<Utilisateur> getDemandes() {
		return demandes;
	}

	public void setDemandes(Collection<Utilisateur> demandes) {
		this.demandes = demandes;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Reagir> getListeReagirs() {
		return listeReagirs;
	}

	public void setListeReagirs(List<Reagir> listeReagirs) {
		this.listeReagirs = listeReagirs;
	}

	public Utilisateur(String password, String nom, String prenom, Sexe sexe, String login,
			RoleUtilisateur roleUtilisateur, String telephone, List<Groupe> listeGroupes,
			List<Message> listeMessagesEnvoyes, List<Message> listeMessagesRecus, List<Publication> listePublications,
			List<Commentaire> listeCommentaires, Collection<Utilisateur> demandeEncours,
			Collection<Utilisateur> demandes) {
		super();
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.login = login;
		this.roleUtilisateur = roleUtilisateur;
		this.telephone = telephone;
		this.listeGroupes = listeGroupes;
		this.listeMessagesEnvoyes = listeMessagesEnvoyes;
		this.listeMessagesRecus = listeMessagesRecus;
		this.listePublications = listePublications;
		this.listeCommentaires = listeCommentaires;
		this.demandeEncours = demandeEncours;
		this.demandes = demandes;
	}

	public Utilisateur() {
	}

	public Utilisateur(String login, String password, RoleUtilisateur roleUtilisateur) {
		this.login = login;
		this.password = password;
		this.roleUtilisateur = roleUtilisateur;
	}

	

	public Utilisateur(String password, String nom, String prenom, Sexe sexe, String login,
			RoleUtilisateur roleUtilisateur, String telephone, String avatar, String description,
			List<Groupe> listeGroupes, List<Message> listeMessagesEnvoyes, List<Message> listeMessagesRecus,
			List<Publication> listePublications, List<Commentaire> listeCommentaires, List<Reagir> listeReagirs,
			Collection<Utilisateur> demandeEncours, Collection<Utilisateur> demandes) {
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.login = login;
		this.roleUtilisateur = roleUtilisateur;
		this.telephone = telephone;
		this.avatar = avatar;
		this.description = description;
		this.listeGroupes = listeGroupes;
		this.listeMessagesEnvoyes = listeMessagesEnvoyes;
		this.listeMessagesRecus = listeMessagesRecus;
		this.listePublications = listePublications;
		this.listeCommentaires = listeCommentaires;
		this.listeReagirs = listeReagirs;
		this.demandeEncours = demandeEncours;
		this.demandes = demandes;
	}
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [password=");
		builder.append(password);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", sexe=");
		builder.append(sexe);
		builder.append(", login=");
		builder.append(login);
		builder.append(", roleUtilisateur=");
		builder.append(roleUtilisateur);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", avatar=");
		builder.append(avatar);
		builder.append(", description=");
		builder.append(description);
		builder.append(", ddn=");
		builder.append(ddn);
		builder.append(", listeGroupes=");
		builder.append(listeGroupes);
		builder.append(", listeMessagesEnvoyes=");
		builder.append(listeMessagesEnvoyes);
		builder.append(", listeMessagesRecus=");
		builder.append(listeMessagesRecus);
		builder.append(", listePublications=");
		builder.append(listePublications);
		builder.append(", listeCommentaires=");
		builder.append(listeCommentaires);
		builder.append(", listeReagirs=");
		builder.append(listeReagirs);
		builder.append(", demandeEncours=");
		builder.append(demandeEncours);
		builder.append(", demandes=");
		builder.append(demandes);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + roleUtilisateur);
		return Collections.singletonList(grantedAuthority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
