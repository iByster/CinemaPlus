package cinematograf.rest.services;


import entities.Offer;
import entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import persistence.interfaces.IOfferRepository;
import persistence.interfaces.IReservationRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("cinematograf/offers")
public class OffersController {
    @Autowired
    private IOfferRepository offerRepository;

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllByClient(@PathVariable String id){

        List<Offer> reservations = offerRepository.getAllOffersByClientId(id);
        if (reservations == null)
            return new ResponseEntity<String>("Reservations not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<List<Offer>>(reservations, HttpStatus.OK);
    }

}
