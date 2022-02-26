package org.mn.projetreseauspring.restcontroller;


import java.util.List;
import java.util.Optional;


import org.mn.projetreseauspring.entity.Publication;
import org.mn.projetreseauspring.repository.PublicationRepository;
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
@RequestMapping("/api/secured/publication")
public class PublicationRestController {
	 private final PublicationRepository publicationRepository;	


	public PublicationRestController(PublicationRepository publicationRepository) {
		this.publicationRepository = publicationRepository;
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
    public Publication getById(@PathVariable long id ) {
        Optional<Publication> optionalPublication = publicationRepository.findById(id);
          return optionalPublication.orElse(null);
    }
    
    @GetMapping("/liste")
    public List<Publication> lister(){
        List<Publication> listePublications = publicationRepository.findAll();
        return listePublications;
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> ajouter(@RequestBody Publication publication){
        publicationRepository.save(publication);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ajout OK");
    }
    
    @PutMapping("/{id}")
    public String update(@PathVariable long id, @RequestBody Publication publication) {
        Optional<Publication> optionalPublication = publicationRepository.findById(id);
        optionalPublication.ifPresent(publicationToEdit -> {
            publicationToEdit.setCommentaires(publication.getCommentaires());
            publicationToEdit.setReagir(publication.getReagir());
            publicationToEdit.setTexte(publication.getTexte());
            publicationToEdit.setUtilisateur(publication.getUtilisateur());
            publicationToEdit.setVisibilite(publication.getVisibilite());           
            publicationRepository.save(publicationToEdit);
        });
        return "Succès";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        publicationRepository.deleteById(id);
        //publicationRepository.delete(entity);
        return "Succès";
    }
    
    // /search?nom=dupont&prenom=ser
    @GetMapping("/search")
    public List<Publication> searchByNom(@RequestParam(required = true, name = "nom") String query){
        return publicationRepository.findAllByTexte(query);
    }
}


