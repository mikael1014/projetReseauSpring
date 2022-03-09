package org.mn.projetreseauspring.restcontroller;


import java.util.List;
import java.util.Optional;


import org.mn.projetreseauspring.entity.Reagir;
import org.mn.projetreseauspring.repository.ReagirRepository;
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
@RequestMapping("/api/secured/reagir")
public class ReagirRestController {
	 private final ReagirRepository reagirRepository;	


	public ReagirRestController(ReagirRepository reagirRepository) {
		this.reagirRepository = reagirRepository;
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
    public Reagir getById(@PathVariable long id ) {
        Optional<Reagir> optionalReagir = reagirRepository.findById(id);
          return optionalReagir.orElse(null);
    }
    
    @GetMapping("/liste")
    public List<Reagir> lister(){
        List<Reagir> listeReagirs = reagirRepository.findAll();
        return listeReagirs;
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> ajouter(@RequestBody Reagir reagir){
        reagirRepository.save(reagir);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ajout OK");
    }
    
    @PutMapping("/{id}")
    public String update(@PathVariable long id, @RequestBody Reagir reagir) {
        Optional<Reagir> optionalReagir = reagirRepository.findById(id);
        optionalReagir.ifPresent(reagirToEdit -> {
            reagirToEdit.setAimer(reagir.getAimer());
            reagirToEdit.setPublication(reagir.getPublication());
            reagirToEdit.setUtilisateur(reagir.getUtilisateur());            
            reagirRepository.save(reagirToEdit);
        });
        return "Succès";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        reagirRepository.deleteById(id);
        //reagirRepository.delete(entity);
        return "Succès";
    }
    
    // /search?nom=dupont&prenom=ser
    @GetMapping("/search")
    public List<Reagir> searchByAimer(@RequestParam(required = true, name = "aimer") String query){
        return reagirRepository.findAllByAimer(query);
    }
}


