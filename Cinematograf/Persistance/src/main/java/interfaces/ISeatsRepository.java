package interfaces;

import entities.Seat;

public interface ISeatsRepository extends IRepositoryCrud<Long, Seat> {
    void deleteAllSeatsByMovie(Long movieId);
}
