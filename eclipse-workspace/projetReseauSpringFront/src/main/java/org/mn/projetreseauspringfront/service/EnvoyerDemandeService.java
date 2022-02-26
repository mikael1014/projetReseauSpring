package org.mn.projetreseauspringfront.service;

import java.util.Map;
import java.util.Set;

import org.mn.projetreseauspringfront.dto.UtilisateurDTO;

public interface EnvoyerDemandeService {

	Set<UtilisateurDTO> getAcceptedEnvoyerDemandehipUtilisateurs(Long id);

	Boolean checkEnvoyerDemandehip(UtilisateurDTO sessionUtilisateur, UtilisateurDTO utilisateur);

	Map<String, Set<UtilisateurDTO>> getEnvoyerDemande(Long id, String search);

	void deleteEnvoyerDemande(UtilisateurDTO utilisateur, Long friendId);

	void acceptEnvoyerDemande(UtilisateurDTO utilisateur, Long friendId);

	void addToEnvoyerDemande(UtilisateurDTO utilisateur, Long friendId);

}
