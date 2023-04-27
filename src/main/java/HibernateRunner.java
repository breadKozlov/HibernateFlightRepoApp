import by.kozlov.entity.Birthday;
import by.kozlov.entity.Gender;
import by.kozlov.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import by.kozlov.entity.User;

import java.time.LocalDate;

public class HibernateRunner {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();
//        configuration.addAnnotatedClass(User.class);
//        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
//        configuration.addAttributeConverter(new BirthdayConvertor(), true);
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = User.builder()
                    .nameUser("Pavel")
                    .birthday(new Birthday(LocalDate.of(1990,1,29)))
                    .email("killersarequiet@gmail.com")
                    .password("password")
                    .role(Role.ADMIN)
                    .gender(Gender.MALE)
                    .build();

            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }
    }
}
