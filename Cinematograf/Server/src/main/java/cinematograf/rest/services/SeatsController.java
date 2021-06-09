package cinematograf.rest.services;

import entities.Client;
import entities.Movie;
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

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSeatsByMovie(@PathVariable Long id){

        List<Seat> seats = seatsRepository.getAllSeatsByMovie(id);
        if (seats == null)
            return new ResponseEntity<String>("Seats not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);
    }

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSeatsByReservation(@PathVariable Long id){

        List<Seat> seats = seatsRepository.getAllSeatsByReservation(id);
        if (seats == null)
            return new ResponseEntity<String>("Seats not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Seat seat) {
        System.out.println("Updating seat ...");
        try{
            seatsRepository.update(seat);
            return new ResponseEntity<Seat>(seat, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Seats not found", HttpStatus.NOT_FOUND);

        }
    }

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSeatsByMovie(@PathVariable Long id) {
//        System.out.println("De seat ...");
        try {
            seatsRepository.deleteAllSeatsByMovie(id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Seats not found", HttpStatus.NOT_FOUND);

        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Seat save(@RequestBody Seat seat){
        System.out.println(seat);
        return seatsRepository.save(seat);
    }
}
