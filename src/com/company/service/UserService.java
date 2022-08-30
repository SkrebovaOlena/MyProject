package com.company.service;

import com.company.dao.UserRepository;
import com.company.view.User;

import java.util.Scanner;

public class UserService {

    private UserRepository userRepository;
    private Scanner scanner = new Scanner(System.in);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loginUser() {

        String username = getUsersName();
        String password = getUsersPassword();

        User user = userRepository.getUserByUsername(username);

        if (user == null) {
            System.out.println(username + ", not found. Please login with another username or register!");
            return null;
        }

        if (user.isBlocked()) {
            System.out.println(username + " is blocked!");
            return null;
        } else if (user.getPassword().equals(password)) {
            System.out.println(username + ", user is successfully logged in!");
            return user;
        } else {
            System.out.println(username + ", entered wrong password, Please try again!");
            return null;
        }
    }

    public User userRegistration() {

        String username = getUsersName();
        String password = getUsersPassword();

        if (userRepository.checkUser(username)) {
            System.out.println(username + " already exists, please login!");
            return null;
        } else {
            User user = new User(username, password, false, false);
            userRepository.addUser(user);
            System.out.println("Registration finished successful");
            return user;
        }
    }

    public void blockUnblockUser() {
        System.out.println("Please specify username to block/unblock");
        String username = scanner.nextLine();
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            System.out.println(username + " doesn't exist");
            return;
        }

        user.setBlocked(!user.isBlocked());
        if (user.isBlocked()) {
            System.out.println(username + " was successfully blocked");
        } else {
            System.out.println(username + " was successfully unblocked");
        }
    }

    private String getUsersPassword() {
        System.out.println("Please write your password");
        return scanner.nextLine();
    }

    public String getUsersName() {
        System.out.println("Please write your username");
        return scanner.nextLine();
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
