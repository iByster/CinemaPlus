package entities;

public class Seat extends Entity<Tuple<Integer, Integer>>{

    private SeatType seatType;

    public Seat(int x, int y) {
        this.seatType = SeatType.FREE;
        this.setId(new Tuple<Integer, Integer>(x,y));
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
