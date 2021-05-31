package persistence.database;

import entities.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import persistence.interfaces.ISeatsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import persistence.validators.Validator;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class DBSeatsRepository implements ISeatsRepository {
    private Validator<Seat> validator;
    @Autowired
    public SessionFactory sessionFactory;

    private static final Logger logger= LogManager.getLogger();

    public DBSeatsRepository(Validator<Seat> validator, SessionFactory sessionFactory) {
        this.validator = validator;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Seat save(Seat seat) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            Long seatID = null;
            try {
                validator.validate(seat);
                tx = session.beginTransaction();
                seatID =(Long) session.save(seat);
                System.out.println("Seat "+ seat +"saved");

                tx.commit();
                seat.setId(seatID);
                return seat;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return seat;
    }

    @Override
    public Seat findOne(Long aLong) {
        Seat seat = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                String queryString = "SELECT * FROM Seats WHERE id="+aLong;
                seat = session.createNativeQuery(queryString, Seat.class).uniqueResult();
                System.out.println("Seats found : \n" + seat);

                tx.commit();

                return seat;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return seat;
    }

    @Override
    public Seat update(Seat seat) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                validator.validate(seat);
                tx = session.beginTransaction();
                session.update(seat);
                System.out.println("Movie "+ seat +"updated");

                tx.commit();

                return seat;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return seat;
    }

    @Override
    public Seat delete(Seat seat) {
        return null;
    }

    @Override
    public List<Seat> getAll() {
        List<Seat> seats = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                String queryString = "SELECT * FROM Seats";
                seats = session.createNativeQuery(queryString, Seat.class).list();
                System.out.println("Seats returned : \n" + seats);

                tx.commit();

                return seats;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return seats;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void deleteAllSeatsByMovie(Long movieId) {

    }

    @Override
    public List<Seat> getAllSeatsByMovie(Long movieId) {
        List<Seat> seats = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                String queryString = "SELECT * FROM Seats WHERE movieID =" + movieId;
                seats = session.createNativeQuery(queryString, Seat.class).list();
                System.out.println("Seats returned : \n" + seats);

                tx.commit();

                return seats;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return seats;
    }
}
