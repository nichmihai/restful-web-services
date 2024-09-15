package com.nichmihai.restapi.restful_web_services.user;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    // JPA/Hibernate > DataBase

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Tim", LocalDate.now().minusYears(20)));
        users.add(new User(++usersCount, "Dave", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Mike", LocalDate.now().minusYears(30)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }


    public void removerUser(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
        User user = users.stream().filter(predicate).findFirst().orElse(null);
    }
}
