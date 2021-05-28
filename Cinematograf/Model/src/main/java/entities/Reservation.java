package entities;

import java.time.LocalDateTime;
import java.util.List;

public class Reservation extends Entity {
    private LocalDateTime reservationDate;
    private Client clientID;
    private List<Seat> seatsIDs;
    private Movie movieID;

    public Reservation(LocalDateTime reservationDate, Client clientID, List<Seat> seatsIDs, Movie movieID) {
        this.reservationDate = reservationDate;
        this.clientID = clientID;
        this.seatsIDs = seatsIDs;
        this.movieID = movieID;
    }
}
