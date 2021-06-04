package persistence.interfaces;

import entities.Reservation;

import java.util.List;

//@Repository
public interface IReservationRepository extends IRepositoryCrud<Reservation, Long> {
    List<Reservation> getAllByClient(String username);
    void deleteAllReservationsByMovie(Long movieID);
}
