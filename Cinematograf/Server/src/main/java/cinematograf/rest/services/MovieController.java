package cinematograf.rest.services;


import entities.Movie;
import entities.Reservation;
import entities.Seat;
import org.springframework.web.bind.annotation.*;
import persistence.exceptions.RepositoryException;
import persistence.interfaces.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("cinematograf/movies")
public class MovieController {

    @Autowired
    private IMovieRepository movieRepository;

    @RequestMapping( method= RequestMethod.GET)
    public ResponseEntity<List<Movie>> getAll(){
        return new ResponseEntity<List<Movie>>(movieRepository.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOneMovie(@PathVariable Long id){

        Movie task = movieRepository.findOne(id);
        if (task == null)
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Movie>(task, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Movie movie){
        System.out.println(movie);

        try {
            movie = movieRepository.save(movie);
            return new ResponseEntity<Movie>(movie, HttpStatus.OK);
        }catch (RepositoryException ex){
            System.out.println("Ctrl Delete user exception");
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id){

        try {
            movieRepository.delete(movieRepository.findOne(id));
            return new ResponseEntity<Movie>(HttpStatus.OK);
        }catch (RepositoryException ex){
            System.out.println("Ctrl Delete user exception");
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Movie movie) {
        System.out.println("Updating movie ...");
        try{
            movieRepository.update(movie);
            return new ResponseEntity<Movie>(movie, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Seats not found", HttpStatus.NOT_FOUND);

        }
    }


}
