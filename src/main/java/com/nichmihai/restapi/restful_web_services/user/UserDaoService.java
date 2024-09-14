package com.nichmihai.restapi.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    // JPA/Hibernate > DataBase

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Tim", LocalDate.now().minusYears(20)));
        users.add(new User(2, "Dave", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Mike", LocalDate.now().minusYears(30)));
    }

    public List<User> findAll() {
        return users;
    }
    // public User save(User user);
    // public User findOne(int id);
}
