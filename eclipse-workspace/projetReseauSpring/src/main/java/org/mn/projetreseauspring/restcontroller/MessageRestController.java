package org.mn.projetreseauspring.restcontroller;


import java.util.List;
import java.util.Optional;


import org.mn.projetreseauspring.entity.Message;
import org.mn.projetreseauspring.repository.MessageRepository;
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
@RequestMapping("/api/secured/message")
public class MessageRestController {
	 private final MessageRepository messageRepository;	


	public MessageRestController(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
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
    public Message getById(@PathVariable long id ) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
          return optionalMessage.orElse(null);
    }
    
    @GetMapping("/liste")
    public List<Message> lister(){
        List<Message> listeMessages = messageRepository.findAll();
        return listeMessages;
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> ajouter(@RequestBody Message message){
        messageRepository.save(message);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ajout OK");
    }
    
    @PutMapping("/{id}")
    public String update(@PathVariable long id, @RequestBody Message message) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        optionalMessage.ifPresent(messageToEdit -> {
            messageToEdit.setContenu(message.getContenu());
            messageToEdit.setDateEnvoi(message.getDateEnvoi());
            messageToEdit.setDestinataire(message.getDestinataire());
            messageToEdit.setExpediteur(message.getExpediteur());
            messageToEdit.setLu(message.isLu());
          
            messageRepository.save(messageToEdit);
        });
        return "Succès";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        messageRepository.deleteById(id);
        //messageRepository.delete(entity);
        return "Succès";
    }
    
    // /search?nom=dupont&prenom=ser
    @GetMapping("/search")
    public List<Message> searchByContenu(@RequestParam(required = true, name = "contenu") String query){
        return messageRepository.findAllByContenu(query);
    }
}


