package persistence.database;

import entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import persistence.interfaces.IMovieRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import persistence.validators.Validator;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class DBMoviesRepository implements IMovieRepository {

    private Validator<Movie> validator;
    @Autowired
    public SessionFactory sessionFactory;

    private static final Logger logger= LogManager.getLogger();

    public DBMoviesRepository(){}

    public DBMoviesRepository(Validator<Movie> validator, SessionFactory sessionFactory) {

        this.validator = validator;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Movie save(Movie movie) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            Long movieID = null;
            try {
                validator.validate(movie);
                tx = session.beginTransaction();
                movieID =(Long) session.save(movie);
                System.out.println("Movie "+ movie +"saved");

                tx.commit();
                movie.setId(movieID);
                return movie;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return movie;
    }

    @Override
    public Movie findOne(Long aLong) {
        Movie movie = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                String queryString = "SELECT * FROM Movies WHERE id="+aLong;
                movie = session.createNativeQuery(queryString, Movie.class).uniqueResult();
                System.out.println("Movies found : \n" + movie);

                tx.commit();

                return movie;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return movie;
    }

    @Override
    public Movie update(Movie movie) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                validator.validate(movie);
                tx = session.beginTransaction();
                session.update(movie);
                System.out.println("Movie "+ movie +"updated");

                tx.commit();

                return movie;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return movie;
    }

    @Override
    public Movie delete(Movie movie) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.delete(movie);
                System.out.println("Movie "+ movie +"deleted");

                tx.commit();

                return movie;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return movie;
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                String queryString = "SELECT * FROM Movies";
                movies = session.createNativeQuery(queryString, Movie.class).list();
                System.out.println("Movies returned : \n" + movies);

                tx.commit();

                return movies;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        return movies;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public List<Movie> filterMovieByType() {
        return null;
    }

    @Override
    public List<Movie> filterMovieByTitle() {
        return null;
    }

    @Override
    public List<Movie> sortMoviesAscendingByTitle() {
        return null;
    }

    @Override
    public List<Movie> sortMoviesDescendingByTitle() {
        return null;
    }

    @Override
    public List<Movie> sortMoviesDescendingByRating() {
        return null;
    }

    @Override
    public List<Movie> sortMoviesAscendingByRating() {
        return null;
    }
}
