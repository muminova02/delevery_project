package uz.doublem.delevery_for_exam.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import uz.doublem.delevery_for_exam.entity.Product;
import uz.doublem.delevery_for_exam.entity.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRepository {

    EntityManagerFactory entityManagerFactory = Configurations.getEntityManagerFactory();



    public void save(Users user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
        } finally {
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }

    public List<Users> getUsers() {
        return null;
    }

    public void saveUser(Users user) {
    }

    public Optional<Users> getUserByEmail(String email) {

        return Optional.empty();

    }

    public void delete(String id) {

    }


    private static UserRepository userRepository;

    public static UserRepository getInstance() {
        if (userRepository == null)
            synchronized (UserRepository.class) {
                if (userRepository == null) {
                    userRepository = new UserRepository();
                }
            }
        return userRepository;
    }


    public Optional<Users> getUserById(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Users user = entityManager.find(Users.class, id);
            return Optional.of(user);
        }catch (Exception e) {
            entityManager.getTransaction().rollback();
            return Optional.empty();
        }
    }

    private Users getUser() throws SQLException {

        return null;
    }
}
