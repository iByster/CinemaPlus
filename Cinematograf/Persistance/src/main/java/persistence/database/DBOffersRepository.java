package persistence.database;

import entities.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import persistence.interfaces.IOfferRepository;
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
public class DBOffersRepository implements IOfferRepository {

    private Validator<Offer> validator;
    @Autowired
    public SessionFactory sessionFactory;

    private static final Logger logger= LogManager.getLogger();

    public DBOffersRepository(Validator<Offer> validator, SessionFactory sessionFactory) {
        this.validator = validator;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Offer save(Offer offer) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            Long offerID = null;
            try {
                validator.validate(offer);
                tx = session.beginTransaction();
                offerID =(Long) session.save(offer);
                System.out.println("Offer "+ offer +"saved");

                tx.commit();
                offer.setId(offerID);
                return offer;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return offer;
    }

    @Override
    public Offer findOne(Long aLong) {
        Offer offer = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                String queryString = "SELECT * FROM Offers WHERE id="+aLong;
                offer = session.createNativeQuery(queryString, Offer.class).uniqueResult();
                System.out.println("Offers found : \n" + offer);

                tx.commit();

                return offer;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return offer;
    }

    @Override
    public Offer update(Offer offer) {
        return null;
    }

    @Override
    public Offer delete(Offer offer) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            Long offerID = null;
            try {

                tx = session.beginTransaction();
                session.delete(offer);
                System.out.println("Offer "+ offer +"deleted");

                tx.commit();
                return offer;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return offer;
    }

    @Override
    public List<Offer> getAll() {
        List<Offer> offers = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                String queryString = "SELECT * FROM Offers";
                offers = session.createNativeQuery(queryString, Offer.class).list();
                System.out.println("Offers returned : \n" + offers);

                tx.commit();

                return offers;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return offers;
    }

    @Override
    public int size() {
        return 0;
    }
}
