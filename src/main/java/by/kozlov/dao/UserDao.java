package by.kozlov.dao;

import by.kozlov.entity.Birthday;
import by.kozlov.entity.Gender;
import by.kozlov.entity.Role;
import by.kozlov.entity.User;
import by.kozlov.utils.HibernateSessionManager;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.query.Query;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserDao implements Dao<Integer, User> {
    private static final UserDao INSTANCE = new UserDao();
    private static final String GET_BY_EMAIL_AND_PASSWORD_SQL =
            "FROM User U WHERE U.email = :email AND U.password = :password";

    @SneakyThrows
    public Optional<User> findByEmailAndPassword(String email, String password) {

        Optional<User> user = null;
        try(var session = HibernateSessionManager.get()) {
            session.beginTransaction();
            Query query = session.createQuery(GET_BY_EMAIL_AND_PASSWORD_SQL);
            query.setParameter("email",email);
            query.setParameter("password",password);
            user = (Optional<User>) query.list().stream().findFirst();
            return user;
        }

    }

    @Override
    @SneakyThrows
    public User save(User entity) {

        try (var session = HibernateSessionManager.get()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            return entity;
        }
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
