package database;

import entities.Client;
import entities.Client;
import interfaces.IClientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import validators.Validator;

import java.util.List;
import java.util.Properties;

public class DBClientRepository implements IClientRepository {

    private Validator<Client> validator;
    public SessionFactory sessionFactory;

    private static final Logger logger= LogManager.getLogger();

    public DBClientRepository(Validator<Client> validator, SessionFactory sessionFactory) {
        logger.info("Initializing repository.DBRepositoryClient with properties: {} ");
        this.validator = validator;
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Client save(Client user) {
        Client client = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                validator.validate(user);
                tx = session.beginTransaction();
//                String queryString = "INSERT * INTO Clients VALUES ('"+ user.getUsername() + "', '" + user.getPassword() + "', " + user.getFidelity() + ", '" + user.getName() + "', '" + user.getTelNumber() + "', " + user.getAge() + ")";
                session.save(user);
                System.out.println("Client with user"+ user.getUsername() +"saved");

                tx.commit();

                return client;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return client;
    }

    @Override
    public Client findOne(String s) {
        Client client = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                String queryString = "SELECT * FROM Clients WHERE username='" + s + "'";
                client = session.createNativeQuery(queryString, Client.class).uniqueResult();
                client.setUsername(client.getUsername());
                System.out.println(client.getUsername() + " "  + client.getPassword());

                tx.commit();

                return client;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return client;
    }

    @Override
    public Client update(Client user) {
        Client client = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                validator.validate(user);
                tx = session.beginTransaction();
                session.update(user);
                System.out.println("User with username: " + user.getUsername() + "update: " + user);

                tx.commit();

                return client;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return client;
    }


    @Override
    public Client delete(Client user) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
