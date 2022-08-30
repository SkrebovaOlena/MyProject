package com.company.dao;

import com.company.view.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private Map<String, User> users = new HashMap<>();

    public void ñreateUsers() {

        users.put("admin", new User("admin", "qwerty", true, false));
        users.put("ivanenko@gmail.com", new User("ivanenko@gmail.com", "12345", false, false));
        users.put("mishka_1989", new User("mishka_1989", "1989", false, false));
        users.put("oksi_m", new User("oksi_m", "345686Q", false, false));
        users.put("torik", new User("torik", "qwerty1234", false, false));
        users.put("Zagorodnii", new User("Zagorodnii", "fgh123", false, false));
        users.put("wolf_12899999", new User("wolf_12899999", "12899999", false, false));
        users.put("sofia_b", new User("sofia_b", "s0987", false, false));
        users.put("stepan_klimenko", new User("stepan_klimenko", "stepan_QSX", false, true));
    }

    public void addUser(User user) {
        users.put(user.getName(), user);
    }

    public User getUserByUsername(String username) {
        return users.get(username);
    }

    public boolean checkUser(String username) {
        return users.containsKey(username);
    }
}
