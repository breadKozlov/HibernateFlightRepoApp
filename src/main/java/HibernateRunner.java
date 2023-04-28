import by.kozlov.dao.FlightDao;
import by.kozlov.dao.TicketDao;
import by.kozlov.entity.*;
import by.kozlov.utils.HibernateSessionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class HibernateRunner {

    public static void main(String[] args) {

//        configuration.addAnnotatedClass(User.class);
//        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
//        configuration.addAttributeConverter(new BirthdayConvertor(), true);
        //var flightDao = FlightDao.getInstance();
        //System.out.println(flightDao.findById(1L));
        var ticketDao = TicketDao.getInstance();
        ticketDao.delete(59L);

        System.out.println(ticketDao.findAll());
    }
}
