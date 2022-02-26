package org.mn.projetreseauspringfront.service;

import java.util.List;

import org.mn.projetreseauspringfront.dto.PageDTO;
import org.mn.projetreseauspringfront.dto.UtilisateurDTO;
import org.mn.projetreseauspringfront.model.Utilisateur;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	private final RestTemplate restTemplate = new RestTemplate();
	private final String URL_UTILISATEUR = "http://localhost:8080/api/secured/utilisateur";

	@Override
	public Utilisateur getById(long id) {
		String URL_UTILISATEUR_ID = URL_UTILISATEUR+ "/"+ id;
		Utilisateur utilisateur = restTemplate.getForObject(URL_UTILISATEUR_ID, Utilisateur.class);		
		return utilisateur;
	}

	@Override
	public List<Utilisateur> lister() {
		// TODO Auto-generated method stub
		ResponseEntity<List<Utilisateur>> responseEntity  = restTemplate.exchange(URL_UTILISATEUR+"/liste",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Utilisateur>>() {});
		return responseEntity.getBody();
	}

	@Override
	public String ajouter(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		HttpEntity<Utilisateur> requestBody =new HttpEntity<>(utilisateur);
		String msg =restTemplate.postForObject(URL_UTILISATEUR, requestBody, String.class);
		return msg;
	}

	@Override
	public Utilisateur getUtilisateur(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UtilisateurDTO getUtilisateurById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UtilisateurDTO getUtilisateurByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageDTO<UtilisateurDTO> findAllPageable(Long id, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageDTO<UtilisateurDTO> findAllWithSearch(Long id, String search, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUtilisateur(UtilisateurDTO utilisateurDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePassword(String password, Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUtilisateur(UtilisateurDTO utilisateurDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUtilisateurImage(UtilisateurDTO utilisateurDTO, String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeUtilisateurAdmin(Long utilisateurId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void blockUtilisateur(Long utilisateurId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UtilisateurDTO getUtilisateurByLogin(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}