package persistence.interfaces;

import entities.Seat;

import java.util.List;

//@Repository
public interface ISeatsRepository extends IRepositoryCrud<Seat, Long> {
    void deleteAllSeatsByMovie(Long movieId);
    List<Seat> getAllSeatsByMovie(Long movieId);
    List<Seat> getAllSeatsByReservation(Long reservationId);
}
