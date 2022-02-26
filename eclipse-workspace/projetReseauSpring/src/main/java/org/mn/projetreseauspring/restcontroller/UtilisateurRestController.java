package org.mn.projetreseauspring.restcontroller;


import java.util.List;
import java.util.Optional;


import org.mn.projetreseauspring.entity.Utilisateur;
import org.mn.projetreseauspring.repository.UtilisateurRepository;
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
@RequestMapping("/api/secured/utilisateur")
public class UtilisateurRestController {
	 private final UtilisateurRepository utilisateurRepository;	


	public UtilisateurRestController(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	@GetMapping
	public String secured() {
		return "Secured Zone";
	}

	@GetMapping("/admin")
	public String securedAdmin() {
		return "Admin Groupe";
	}
	
	 
    @GetMapping("/{id}")
    public Utilisateur getById(@PathVariable long id ) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
          return optionalUtilisateur.orElse(null);
    }
    
    @GetMapping("/liste")
    public List<Utilisateur> lister(){
        List<Utilisateur> listeUtilisateurs = utilisateurRepository.findAll();
        return listeUtilisateurs;
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> ajouter(@RequestBody Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ajout OK");
    }
    
    @PutMapping("/{id}")
    public String update(@PathVariable long id, @RequestBody Utilisateur utilisateur) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        optionalUtilisateur.ifPresent(utilisateurToEdit -> {
            utilisateurToEdit.setLogin(utilisateur.getLogin());
            utilisateurToEdit.setPassword(utilisateur.getPassword());
            utilisateurToEdit.setNom(utilisateur.getNom());
            utilisateurToEdit.setPrenom(utilisateur.getPrenom());
            utilisateurToEdit.setSexe(utilisateur.getSexe());
            utilisateurToEdit.setTelephone(utilisateur.getTelephone());
            utilisateurToEdit.setAvatar(utilisateur.getAvatar());
            utilisateurToEdit.setDescription(utilisateur.getDescription());
            utilisateurToEdit.setDdn(utilisateur.getDdn());
            utilisateurRepository.save(utilisateurToEdit);
        });
        return "Succès";
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        utilisateurRepository.deleteById(id);
        //utilisateurRepository.delete(entity);
        return "Succès";
    }
    
    // /search?nom=dupont&prenom=ser
    @GetMapping("/search")
    public List<Utilisateur> searchByNom(@RequestParam(required = true, name = "nom") String query){
        return utilisateurRepository.findAllByNom(query);
    }
}


