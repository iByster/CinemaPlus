package entities;

import java.time.LocalDateTime;

public class Reservation extends Entity<Long> {
    private LocalDateTime reservationDate;
    private Long clientID;
    private Tuple<Integer, Integer> seatID;
    private Long MovieID;

    public Reservation(LocalDateTime reservationDate, Long clientID, Tuple<Integer, Integer> seatID, Long movieID) {
        this.reservationDate = reservationDate;
        this.clientID = clientID;
        this.seatID = seatID;
        MovieID = movieID;
    }
}
