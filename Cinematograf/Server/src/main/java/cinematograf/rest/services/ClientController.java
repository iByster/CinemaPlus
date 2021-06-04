package cinematograf.rest.services;


import entities.Client;
import entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import persistence.exceptions.RepositoryException;
import persistence.interfaces.IClientRepository;
import persistence.interfaces.IMovieRepository;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("cinematograf/clients")
public class ClientController {
    @Autowired
    private IClientRepository clientRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable String id){

        Client task = clientRepository.findOne(id);
        if (task == null)
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Client>(task, HttpStatus.OK);
    }

    @RequestMapping( value = "", method= RequestMethod.GET)
    public ResponseEntity<?> login(
            @RequestParam("username") String username, @RequestParam("password") String password){
        Client client = clientRepository.findOne(username);
        if(client.getPassword().equals(password)){
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Client client){
        System.out.println(client);

        try {
            client = clientRepository.save(client);
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        }catch (RepositoryException ex){
            System.out.println("Ctrl Delete user exception");
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
