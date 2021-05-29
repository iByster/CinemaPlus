package entities;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "Seats")
public class Seat extends Entity {
    @Column(name = "x", nullable = false)
    private int x;
    @Column(name = "y", nullable = false)
    private int y;
    @Enumerated(EnumType.STRING)
    @Column(name = "seatType", nullable = false)
    private SeatType seatType;
    @ManyToOne
    @JoinColumn(name ="movieID")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name ="reservationId")
    private Reservation reservation;

    public Seat(){}

    public Seat(int x, int y, SeatType seatType, Movie movie, Reservation reservation) {
        this.x = x;
        this.y = y;
        this.seatType = seatType;
        this.movie = movie;
        this.reservation = reservation;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Movie getMovie() {
        return movie;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "x=" + x +
                ", y=" + y +
                ", seatType=" + seatType +
                ", movie=" + movie +
                ", reservation=" + reservation +
                '}';
    }
}
