package entities;

public class Seat extends Entity {
    private int x;
    private int y;
    private SeatType seatType;
    private Movie movie;
    private Reservation reservation;

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
}
