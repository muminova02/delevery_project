package uz.doublem.delevery_for_exam.repository;

import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

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

    @SneakyThrows
    public List<Users> getUsers() {
        return null;
    }

    @SneakyThrows
    public void saveUser(Users user) {
    }

    @SneakyThrows
    public Optional<Users> getUserByEmail(String email) {

        return Optional.empty();

    }
    @SneakyThrows
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

    @SneakyThrows
    public Optional<Users> getUserById(String id) {

        return Optional.empty();
    }

    private Users getUser() throws SQLException {

        return null;
    }
}
