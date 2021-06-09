package cinematograf.rest.services;

import entities.Movie;
import entities.Reservation;
import entities.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import persistence.interfaces.IReservationRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("cinematograf/reservations")
public class ReservationController {
    @Autowired
    private IReservationRepository reservationRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Reservation reservation){
        System.out.println(reservation);

        try{
            reservation = reservationRepository.save(reservation);
            return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Reservations not found", HttpStatus.NOT_FOUND);

        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllByClient(@PathVariable String id){

        List<Reservation> reservations = reservationRepository.getAllByClient(id);
        if (reservations == null)
            return new ResponseEntity<String>("Reservations not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSeatsByMovie(@PathVariable Long id) {
        try {
            reservationRepository.deleteAllReservationsByMovie(id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Reservations not found", HttpStatus.NOT_FOUND);

        }
    }





}
