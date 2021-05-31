package persistence.database;

import entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import persistence.interfaces.IAdminRepository;
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
public class DBAdminRepository implements IAdminRepository {

    private Validator<Admin> validator;
    @Autowired
    public SessionFactory sessionFactory;

    private static final Logger logger= LogManager.getLogger();

    public DBAdminRepository(Validator<Admin> validator, SessionFactory sessionFactory) {
        this.validator = validator;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Admin save(Admin admin) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            String adminID = null;
            try {
                validator.validate(admin);
                tx = session.beginTransaction();
                adminID = (String) session.save(admin);
                System.out.println("Admin "+ admin +"saved");

                tx.commit();
                admin.setUsername(adminID);
                return admin;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return admin;
    }

    @Override
    public Admin findOne(String s) {
        Admin admin = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                String queryString = "SELECT * FROM Admins WHERE username='" + s + "'";
                admin = session.createNativeQuery(queryString, Admin.class).uniqueResult();
                admin.setUsername(admin.getUsername());
                System.out.println(admin.getUsername() + " "  + admin.getPassword());

                tx.commit();

                return admin;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return admin;
    }

    @Override
    public Admin update(Admin admin) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                validator.validate(admin);
                tx = session.beginTransaction();
                session.update(admin);
                System.out.println("Admin "+ admin +"updated");

                tx.commit();

                return admin;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return admin;
    }

    @Override
    public Admin delete(Admin admin) {
        return null;
    }

    @Override
    public List<Admin> getAll() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
