package org.mn.projetreseauspring.restcontroller;


import java.util.List;
import java.util.Optional;


import org.mn.projetreseauspring.entity.Groupe;
import org.mn.projetreseauspring.repository.GroupeRepository;
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
@RequestMapping("/api/secured/groupe")
public class GroupeRestController {
	 private final GroupeRepository groupeRepository;	


	public GroupeRestController(GroupeRepository groupeRepository) {
		this.groupeRepository = groupeRepository;
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
    public Groupe getById(@PathVariable long id ) {
        Optional<Groupe> optionalGroupe = groupeRepository.findById(id);
          return optionalGroupe.orElse(null);
    }
    
    @GetMapping("/liste")
    public List<Groupe> lister(){
        List<Groupe> listeGroupes = groupeRepository.findAll();
        return listeGroupes;
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> ajouter(@RequestBody Groupe groupe){
        groupeRepository.save(groupe);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ajout OK");
    }
    
    @PutMapping("/{id}")
    public String update(@PathVariable long id, @RequestBody Groupe groupe) {
        Optional<Groupe> optionalGroupe = groupeRepository.findById(id);
        optionalGroupe.ifPresent(groupeToEdit -> {
            groupeToEdit.setAdherent(groupe.getAdherent());
            groupeToEdit.setAdherents(groupe.getAdherents());
            groupeToEdit.setDescription(groupe.getDescription());
            groupeToEdit.setLibelle(groupe.getLibelle());
            groupeToEdit.setRoleAdherent(groupe.getRoleAdherent());           
            groupeRepository.save(groupeToEdit);
        });
        return "Succès";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        groupeRepository.deleteById(id);
        //groupeRepository.delete(entity);
        return "Succès";
    }
    
    // /search?nom=dupont&prenom=ser
    @GetMapping("/search")
    public List<Groupe> searchByLibelle(@RequestParam(required = true, name = "libelle") String query){
        return groupeRepository.findAllByLibelle(query);
    }
}


