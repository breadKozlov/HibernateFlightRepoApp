
import by.kozlov.dao.TicketDao;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class HibernateRunner {
    public static void main(String[] args) {

//        configuration.addAnnotatedClass(User.class);
//        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
//        configuration.addAttributeConverter(new BirthdayConvertor(), true);
        //var flightDao = FlightDao.getInstance();
        //System.out.println(flightDao.findById(1L));

        var ticketDao = TicketDao.getInstance();

        log.info("Find All tickets");
        System.out.println(ticketDao.findAll());
    }
}
