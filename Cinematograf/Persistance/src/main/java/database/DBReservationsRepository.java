package database;

import entities.Reservation;
import entities.Reservation;
import entities.Reservation;
import interfaces.IReservationsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import validators.Validator;

import java.util.List;

public class DBReservationsRepository implements IReservationsRepository {
    private Validator<Reservation> validator;
    public SessionFactory sessionFactory;

    private static final Logger logger= LogManager.getLogger();

    public DBReservationsRepository(Validator<Reservation> validator, SessionFactory sessionFactory) {
        this.validator = validator;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Reservation save(Reservation reservation) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            Long reservationID = null;
            try {
                validator.validate(reservation);
                tx = session.beginTransaction();
                reservationID =(Long) session.save(reservation);
                System.out.println("Reservation "+ reservation +"saved");

                tx.commit();
                reservation.setId(reservationID);
                return reservation;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return reservation;
    }

    @Override
    public Reservation findOne(Long aLong) {
        Reservation reservation = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                String queryString = "SELECT * FROM Reservations WHERE id="+aLong;
                reservation = session.createNativeQuery(queryString, Reservation.class).uniqueResult();
                System.out.println("Reservations found : \n" + reservation);

                tx.commit();

                return reservation;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return reservation;
    }

    @Override
    public Reservation update(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation delete(Reservation reservation) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            Long reservationID = null;
            try {
                
                tx = session.beginTransaction();
                session.delete(reservation);
                System.out.println("Reservation "+ reservation +"deleted");

                tx.commit();
                return reservation;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return reservation;
    
    }

    @Override
    public List<Reservation> getAll() {
        List<Reservation> reservations = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                String queryString = "SELECT * FROM Reservations";
                reservations = session.createNativeQuery(queryString, Reservation.class).list();
                System.out.println("Reservations returned : \n" + reservations);

                tx.commit();

                return reservations;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return reservations;
    }

    @Override
    public int size() {
        return 0;
    }
}
