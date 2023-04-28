package by.kozlov.dao;

import by.kozlov.entity.Ticket;
import by.kozlov.utils.HibernateSessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long, Ticket> {
    private static final TicketDao INSTANCE = new TicketDao();
    private static String FIND_ALL_HIB = "FROM Ticket T ";
    private static String FIND_ALL_BY_FLIGHT_HIB = FIND_ALL_HIB + """
            WHERE T.flight.id = :flight_id
            """;

    public List<Ticket> findAllByFlightId(Long flightId) {

        List<Ticket> result = new ArrayList<>();
        try(Session session = HibernateSessionManager.get()) {
            session.beginTransaction();
            Query query = session.createQuery(FIND_ALL_BY_FLIGHT_HIB)
                    .setParameter("flight_id",flightId);
            List tickets = query.list();
            result.addAll(tickets);
            session.getTransaction().commit();
        }
        return result;
    }

    public boolean update(Ticket ticket) {
        try (var session = HibernateSessionManager.get()){

            session.beginTransaction();
            session.update(ticket);
            session.getTransaction().commit();
            return true;
        }
    }

    public Optional<Ticket> findById(Long id) {
        Ticket ticket = null;
        try(var session = HibernateSessionManager.get()) {
            session.beginTransaction();
            ticket = session.get(Ticket.class,id);
            session.getTransaction().commit();
        }
        return Optional.ofNullable(ticket);
    }

    public List<Ticket> findAll() {
        List<Ticket> result = new ArrayList<>();
        try(var session = HibernateSessionManager.get()) {
            session.beginTransaction();
            List tickets = session.createQuery(FIND_ALL_HIB).list();
            result.addAll(tickets);
            session.getTransaction().commit();
        }
        return result;
    }

    public boolean delete(Long id) {

        try(var session = HibernateSessionManager.get()) {
            session.beginTransaction();
            session.delete(session.get(Ticket.class,id));
            session.getTransaction().commit();
            return true;
        }
    }

    public Ticket save(Ticket ticket) {
        try (var session = HibernateSessionManager.get()) {
            session.beginTransaction();
            session.save(ticket);
            session.getTransaction().commit();
            return ticket;
        }
    }

    public static TicketDao getInstance() {
        return INSTANCE;
    }

    private TicketDao() {
    }
}
