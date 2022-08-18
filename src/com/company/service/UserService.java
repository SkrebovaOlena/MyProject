package com.company.service;

import com.company.dao.UserRepository;

import java.util.Scanner;

public class UserService {

    Scanner scanner = new Scanner(System.in);

    public void loginUser(UserRepository userRepository) {

        String username = getUsersName();
        String password = getUsersPassword();

        if (userRepository.checkUser(username)) {
            System.out.println(username + ", we are glad to see again!");
        }
        else {
            System.out.println(username + " is not found. Registrate yourself");
            userRegistration(userRepository);
        }
    }

    public void userRegistration(UserRepository userRepository){

        String username = getUsersName();
        String password = getUsersPassword();

        if (userRepository.checkUser(username)) {
            System.out.println(username + " is found, we're glad to see you again!");
        }
        else {
            userRepository.addUser(username, password);
            System.out.println("Registration finished successful");
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
}
