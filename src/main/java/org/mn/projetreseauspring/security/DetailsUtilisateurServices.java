package org.mn.projetreseauspring.security;

import java.util.Optional;

import org.mn.projetreseauspring.entity.Utilisateur;
import org.mn.projetreseauspring.repository.UtilisateurRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetailsUtilisateurServices implements UserDetailsService {

	private final UtilisateurRepository utilisateurRepository;

	public DetailsUtilisateurServices(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<Utilisateur> optionalUtilateur = Optional.ofNullable(utilisateurRepository.findUtilisateurBylogin(login));
		if (optionalUtilateur.isPresent()) {
			return optionalUtilateur.get();
		}
		throw new UsernameNotFoundException(login + " Pas en BD");
	}

}
