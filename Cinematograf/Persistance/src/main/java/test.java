import persistence.database.*;
import entities.*;
import persistence.interfaces.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import persistence.validators.*;

import java.util.Calendar;

public class test {
    private static SessionFactory sessionFactory;

    static void initialize() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            System.err.println("Exceptie "+e);
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    static void close() {
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }

    private static void testDBClient(){
        IClientRepository dbClientRepository = new DBClientRepository(new ClientValidator(), sessionFactory);
        System.out.println(dbClientRepository.findOne("ganealex"));
        Client client = new Client("bogdan", "123456", 0, "Mircea Mictariu", "021938083", 20);
        dbClientRepository.update(client);
    }

    private static void testDBAdmin() {
        IAdminRepository adminRepository = new DBAdminRepository(new AdminValidator(), sessionFactory);
        System.out.println(adminRepository.findOne("admin"));
    }

    private static void testDBMovie() {
        IMovieRepository dbMovieRepository = new DBMoviesRepository(new MovieValidator(), sessionFactory);
        Movie movie = new Movie("Batman","02:00", 8, "Good for you! <3", "Actiune", "");
        movie = dbMovieRepository.save(movie);
        dbMovieRepository.getAll();
        System.out.println(dbMovieRepository.findOne(movie.getId()));
        movie.setTitle("Lion King 2");
        dbMovieRepository.update(movie);
        System.out.println(dbMovieRepository.findOne(movie.getId()));
        dbMovieRepository.delete(movie);
        try {
            dbMovieRepository.findOne(movie.getId());
        }catch (RuntimeException e){
            System.out.println("Movie not found");
        }
    }

    public static void testDBSteats() {
        ISeatsRepository seatsRepository = new DBSeatsRepository(new SeatValidator(), sessionFactory);
//        int switch_aux = 0;
//        int row = 1;
//        int col = 0;
//        Movie movie = new Movie();
//        movie.setId(5L);
//        for(int i = 1; i <= 42; i++){
//
//            col++;
//            Seat seat = new Seat(row, col, SeatType.FREE ,movie, null);
//            if(switch_aux == 0){
//                if(col == 10){
//                    switch_aux = 1;
//                    col = 0;
//                    row++;
//                }
//            } else {
//                if(col == 11){
//                    switch_aux = 0;
//                    col = 0;
//                    row++;
//                }
//            }
//            seatsRepository.save(seat);
//
//        }
        seatsRepository.deleteAllSeatsByMovie(9L);
//        Seat seat = seatsRepository.findOne(32L);
//        seat.setReservation(new Reservation("2"));
//        seatsRepository.update(seat);
    }

    private static void testDBReservations(){
        IReservationRepository reservationsRepository = new DBReservationsRepository(new ReservationValidator(), sessionFactory);
//        ISeatsRepository seatsRepository = new DBSeatsRepository(new SeatValidator(), sessionFactory);
//        List<Seat> seatList = new ArrayList<>();
//        seatList.add(seatsRepository.findOne(1L));
//        seatList.add(seatsRepository.findOne(2L));
//        Movie movie = new Movie();
//        movie.setId(5L);
        reservationsRepository.deleteAllReservationsByMovie(9L);
//        Client client = new Client();
//        client.setUsername("bogdan");
//        Reservation reservation = new Reservation(Calendar.getInstance(), client, movie);
//        Reservation reservation2 = reservationsRepository.save(reservation);
//        System.out.println(reservation2);
//        seatList.get(0).setReservation(reservation);
//        seatList.get(0).setSeatType(SeatType.TAKEN);
//        seatList.get(1).setSeatType(SeatType.TAKEN);
//        seatList.get(1).setReservation(reservation);
//        seatsRepository.update(seatList.get(0));
//        seatsRepository.update(seatList.get(1));

//        reservation = reservationsRepository.findOne(1L);
//        System.out.println(reservation.getClientID());
//        System.out.println(reservation.getMovieID());
//        reservation.getSeatsIDs().forEach(System.out::println);
    }

    private static void testOffers(){

        Client client = new Client();
        client.setUsername("ganealex");

        IOfferRepository offerRepository = new DBOffersRepository(new OfferValidator(), sessionFactory);
//        offer = offerRepository.save(offer);
        Offer offer = offerRepository.findOne(2L);
        System.out.println(offer.getClient());
        System.out.println(offer.getId());
    }




    public static void main(String ... arg) {
        initialize();

        testDBSteats();

        close();
    }
}
