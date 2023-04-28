package by.kozlov.dao;

import by.kozlov.entity.Flight;
import by.kozlov.utils.HibernateSessionManager;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight>{
    private static final FlightDao INSTANCE = new FlightDao();
    private static String FIND_ALL_HIB = "from Flight";

    @Override
    public boolean update(Flight flight) {
        return false;
    }

    @Override
    public List<Flight> findAll() {

        List<Flight> result = new ArrayList<>();
        try (Session session = HibernateSessionManager.get()) {
            session.beginTransaction();
            List flights = session.createQuery(FIND_ALL_HIB).getResultList();
            result.addAll(flights);
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Flight save(Flight flight) {
        return null;
    }

    public static FlightDao getInstance() {
        return INSTANCE;
    }

    private FlightDao() {
    }

    @Override
    public Optional<Flight> findById(Long flightId) {
        Flight flight = null;
        try(var session = HibernateSessionManager.get()) {
            session.beginTransaction();
            flight = session.get(Flight.class,flightId);
            session.getTransaction().commit();
        }
        return Optional.ofNullable(flight);
    }
}
