package org.mn.projetreseauspring.restcontroller;


import java.util.List;
import java.util.Optional;


import org.mn.projetreseauspring.entity.Commentaire;
import org.mn.projetreseauspring.repository.CommentaireRepository;
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
@RequestMapping("/api/secured/commentaire")
public class CommentaireRestController {
	 private final CommentaireRepository commentaireRepository;	


	public CommentaireRestController(CommentaireRepository commentaireRepository) {
		this.commentaireRepository = commentaireRepository;
	}

	
	@GetMapping
	public String secured() {
		return "Secured Zone";
	}

    @GetMapping("/{id}")
    public Commentaire getById(@PathVariable long id ) {
        Optional<Commentaire> optionalCommentaire = commentaireRepository.findById(id);
          return optionalCommentaire.orElse(null);
    }
    
    @GetMapping("/liste")
    public List<Commentaire> lister(){
        List<Commentaire> listeCommentaires = commentaireRepository.findAll();
        return listeCommentaires;
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> ajouter(@RequestBody Commentaire commentaire){
        commentaireRepository.save(commentaire);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ajout OK");
    }
    
    @PutMapping("/{id}")
    public String update(@PathVariable long id, @RequestBody Commentaire commentaire) {
        Optional<Commentaire> optionalCommentaire = commentaireRepository.findById(id);
        optionalCommentaire.ifPresent(commentaireToEdit -> {
            commentaireToEdit.setDatePoster(commentaire.getDatePoster());
            commentaireToEdit.setPublication(commentaire.getPublication());
            commentaireToEdit.setTexte(commentaire.getTexte());
            commentaireToEdit.setUtilisateur(commentaire.getUtilisateur());
            
            commentaireRepository.save(commentaireToEdit);
        });
        return "Succès";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        commentaireRepository.deleteById(id);
        //commentaireRepository.delete(entity);
        return "Succès";
    }
    
    // /search?nom=dupont&prenom=ser
    @GetMapping("/search")
    public List<Commentaire> searchByTexte(@RequestParam(required = true, name = "texte") String query){
        return commentaireRepository.findAllByTexte(query);
    }
}


