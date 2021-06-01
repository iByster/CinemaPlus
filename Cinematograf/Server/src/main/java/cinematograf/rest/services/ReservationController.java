package cinematograf.rest.services;

import entities.Movie;
import entities.Reservation;
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
    public Reservation save(@RequestBody Reservation reservation){
        System.out.println(reservation);
        return reservationRepository.save(reservation);
    }

    @RequestMapping( method= RequestMethod.GET)
    public ResponseEntity<List<Reservation>> getAll(){
        return new ResponseEntity<List<Reservation>>(reservationRepository.getAll(), HttpStatus.OK);
    }




}
