package org.mn.projetreseauspringfront.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.mn.projetreseauspringfront.model.Utilisateur;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

//    private LocalDateTime time;

	@NotNull
	@Size(min = 3, max = 3000)
	private String contenu;
	private UtilisateurDTO expediteur;
	private UtilisateurDTO destinataire;
	private Long companionId;
	private LocalDateTime dateEnvoi;

	private boolean lu = false;

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public UtilisateurDTO getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(UtilisateurDTO expediteur) {
		this.expediteur = expediteur;
	}

	public UtilisateurDTO getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(UtilisateurDTO destinataire) {
		this.destinataire = destinataire;
	}

	public Long getCompanionId() {
		return companionId;
	}

	public void setCompanionId(Long companionId) {
		this.companionId = companionId;
	}

	public LocalDateTime getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(LocalDateTime dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public boolean isLu() {
		return lu;
	}

	public void setLu(boolean lu) {
		this.lu = lu;
	}

	public MessageDTO(@NotNull @Size(min = 3, max = 3000) String contenu, UtilisateurDTO expediteur,
			UtilisateurDTO destinataire, Long companionId, LocalDateTime dateEnvoi, boolean lu) {
		this.contenu = contenu;
		this.expediteur = expediteur;
		this.destinataire = destinataire;
		this.companionId = companionId;
		this.dateEnvoi = dateEnvoi;
		this.lu = lu;
	}

	public MessageDTO() {
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageDTO [contenu=");
		builder.append(contenu);
		builder.append(", expediteur=");
		builder.append(expediteur);
		builder.append(", destinataire=");
		builder.append(destinataire);
		builder.append(", companionId=");
		builder.append(companionId);
		builder.append(", dateEnvoi=");
		builder.append(dateEnvoi);
		builder.append(", lu=");
		builder.append(lu);
		builder.append("]");
		return builder.toString();
	}

}
