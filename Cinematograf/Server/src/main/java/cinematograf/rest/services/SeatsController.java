package cinematograf.rest.services;

import entities.Client;
import entities.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import persistence.interfaces.ISeatsRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("cinematograf/seats")
public class SeatsController {

    @Autowired
    private ISeatsRepository seatsRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSeatsByMovie(@PathVariable Long id){

        List<Seat> seats = seatsRepository.getAllSeatsByMovie(id);
        if (seats == null)
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);
    }
}
