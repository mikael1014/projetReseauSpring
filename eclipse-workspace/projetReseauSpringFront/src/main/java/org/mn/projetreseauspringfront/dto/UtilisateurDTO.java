package org.mn.projetreseauspringfront.dto;

import lombok.*;

import org.mn.projetreseauspringfront.validation.FieldMatch;
import org.mn.projetreseauspringfront.validation.Password;
import org.mn.projetreseauspringfront.validation.ValidEmail;
import org.mn.projetreseauspringfront.entiy.enum_.RoleUtilisateur;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;


@ToString
@FieldMatch.List({
        @FieldMatch(first = "password", second = "passwordConfirmation", message = "Password fields must match")
})
public class UtilisateurDTO {

	   private Long id;

	    @NotNull
	    @ValidEmail
		private String login;//email

	    @NotNull
	    @Size(min=6, max=100, message = "Min size is 6 and max size is 100")
	    @Password
	    private String password;

	    @NotNull
	    @Size(min=6, max=100, message = "Min size is 6 and max size is 100")
	    private String passwordConfirmation;

	    @NotNull
	    @Size(min=2, max=100, message = "Min size is 2 and max size is 100")
	    private String nom;

	    @NotNull
	    @Size(min=2, max=100, message = "Min size is 2 and max size is 100")
	    private String prenom;

	    @PastOrPresent
	    @DateTimeFormat(pattern = "dd.MM.yyyy")
	    private LocalDate ddn;

	    
	    
	    private String sexe;

		private String telephone;

		private RoleUtilisateur roleUtilisateur;//private Boolean isAdmin;

		private String avatar;



		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPasswordConfirmation() {
			return passwordConfirmation;
		}

		public void setPasswordConfirmation(String passwordConfirmation) {
			this.passwordConfirmation = passwordConfirmation;
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

		public LocalDate getddn() {
			return ddn;
		}

		public void setddn(LocalDate ddn) {
			this.ddn = ddn;
		}

		public String getSexe() {
			return sexe;
		}

		public void setSexe(String sexe) {
			this.sexe = sexe;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public RoleUtilisateur getRoleUtilisateur() {
			return roleUtilisateur;
		}

		public void setRoleUtilisateur(RoleUtilisateur roleUtilisateur) {
			this.roleUtilisateur = roleUtilisateur;
		}

		public String getAvatar() {
			return avatar;
		}

		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        UtilisateurDTO user = (UtilisateurDTO) o;
	        return id.equals(user.id);
	    }

	    @Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("UtilisateurDTO [id=");
			builder.append(id);
			builder.append(", login=");
			builder.append(login);
			builder.append(", password=");
			builder.append(password);
			builder.append(", passwordConfirmation=");
			builder.append(passwordConfirmation);
			builder.append(", nom=");
			builder.append(nom);
			builder.append(", prenom=");
			builder.append(prenom);
			builder.append(", ddn=");
			builder.append(ddn);
			builder.append(", sexe=");
			builder.append(sexe);
			builder.append(", telephone=");
			builder.append(telephone);
			builder.append(", roleUtilisateur=");
			builder.append(roleUtilisateur);
			builder.append(", avatar=");
			builder.append(avatar);
			builder.append("]");
			return builder.toString();
		}

		@Override
	    public int hashCode() {
	        return Objects.hash(id);
	    }

		public UtilisateurDTO() {
		}

		public UtilisateurDTO(Long id, @NotNull String login,
				@NotNull @Size(min = 6, max = 100, message = "Min size is 6 and max size is 100") String password,
				@NotNull @Size(min = 6, max = 100, message = "Min size is 6 and max size is 100") String passwordConfirmation,
				@NotNull @Size(min = 2, max = 100, message = "Min size is 2 and max size is 100") String nom,
				@NotNull @Size(min = 2, max = 100, message = "Min size is 2 and max size is 100") String prenom,
				@PastOrPresent LocalDate ddn, String sexe, String telephone, RoleUtilisateur roleUtilisateur,
				String avatar) {
			this.id = id;
			this.login = login;
			this.password = password;
			this.passwordConfirmation = passwordConfirmation;
			this.nom = nom;
			this.prenom = prenom;
			this.ddn = ddn;
			this.sexe = sexe;
			this.telephone = telephone;
			this.roleUtilisateur = roleUtilisateur;
			this.avatar = avatar;
		}

	}
