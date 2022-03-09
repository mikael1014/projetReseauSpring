package org.mn.projetreseauspring.restcontroller;


import java.util.List;
import java.util.Optional;


import org.mn.projetreseauspring.entity.EnvoyerDemande;
import org.mn.projetreseauspring.repository.EnvoyerDemandeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 *
 * @author Mike
 */
@RestController
@RequestMapping("/api/secured/envoyerDemande")
public class EnvoyerDemandeRestController {
	 private final EnvoyerDemandeRepository envoyerDemandeRepository;	


	public EnvoyerDemandeRestController(EnvoyerDemandeRepository envoyerDemandeRepository) {
		this.envoyerDemandeRepository = envoyerDemandeRepository;
	}


	@GetMapping
	public String secured() {
		return "Secured Zone";
	}

	 
    @GetMapping("/{id}")
    public EnvoyerDemande getById(@PathVariable long id ) {
        Optional<EnvoyerDemande> optionalEnvoyerDemande = envoyerDemandeRepository.findById(id);
          return optionalEnvoyerDemande.orElse(null);
    }
    
    @GetMapping("/liste")
    public List<EnvoyerDemande> lister(){
        List<EnvoyerDemande> listeEnvoyerDemandes = envoyerDemandeRepository.findAll();
        return listeEnvoyerDemandes;
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> ajouter(@RequestBody EnvoyerDemande envoyerDemande){
        envoyerDemandeRepository.save(envoyerDemande);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ajout OK");
    }
    
    @PutMapping("/{id}")
    public String update(@PathVariable long id, @RequestBody EnvoyerDemande envoyerDemande) {
        Optional<EnvoyerDemande> optionalEnvoyerDemande = envoyerDemandeRepository.findById(id);
        optionalEnvoyerDemande.ifPresent(envoyerDemandeToEdit -> {
            envoyerDemandeToEdit.setEtat(envoyerDemande.getEtat());
            envoyerDemandeToEdit.setUtilisateurDestinataire(envoyerDemande.getUtilisateurDestinataire());
            envoyerDemandeToEdit.setUtilisateurExpediteur(envoyerDemande.getUtilisateurExpediteur());
            envoyerDemandeRepository.save(envoyerDemandeToEdit);
        });
        return "Succès";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        envoyerDemandeRepository.deleteById(id);
        //envoyerDemandeRepository.delete(entity);
        return "Succès";
    }
    
    // /search?nom=dupont&prenom=ser
    @GetMapping("/search")
    public List<EnvoyerDemande> searchByEtat(@RequestParam(required = true, name = "etat") String query){
        return envoyerDemandeRepository.findAllByEtat(query);
    }
}


