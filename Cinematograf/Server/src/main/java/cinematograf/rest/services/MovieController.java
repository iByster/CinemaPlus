package cinematograf.rest.services;


import entities.Movie;
import org.springframework.web.bind.annotation.CrossOrigin;
import persistence.interfaces.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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



}
