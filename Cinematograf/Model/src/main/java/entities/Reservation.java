package entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@javax.persistence.Entity
@Table(name = "Reservations")
public class Reservation extends Entity {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private Calendar reservationDate;
    @ManyToOne
    @JoinColumn(name ="clientId")
    private Client clientID;
//    @OneToMany(fetch = FetchType.EAGER, mappedBy="reservation", cascade = CascadeType.ALL)
//    private List<Seat> seatsIDs;
    @ManyToOne
    @JoinColumn(name ="movieId")
    private Movie movieID;

    public Reservation(){}

    public Reservation(Long id){
        this.setId(id);
    }

    public Reservation(Calendar reservationDate, Client clientID, Movie movieID) {
        this.reservationDate = reservationDate;
        this.clientID = clientID;
        this.movieID = movieID;
    }

    public Calendar getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Calendar reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Client getClientID() {
        return clientID;
    }

    public void setClientID(Client clientID) {
        this.clientID = clientID;
    }

    public Movie getMovieID() {
        return movieID;
    }

    public void setMovieID(Movie movieID) {
        this.movieID = movieID;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationDate=" + reservationDate +
                ", clientID=" + clientID +
                ", movieID=" + movieID +
                '}';
    }
}
