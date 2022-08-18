package com.company.view;

import com.company.dao.UserRepository;
import com.company.service.UserService;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    String command = scanner.nextLine();

    public void startMenu() {

        UserRepository userRepository = new UserRepository();
        userRepository.ñreateUsers();


        UserService userService = new UserService();

        do{
            System.out.println("Please make your choice");
            System.out.println("1: registration");
            System.out.println("2: authorization");
            System.out.println("0: exit");

            switch (command){
                case "1":
                    userService.userRegistration(userRepository);
                    choiceMenu();
                    break;
                case "2":
                    userService.loginUser(userRepository);
                    choiceMenu();
                    break;
                case "0":
                    System.out.println("Good bye! Have a nice day!");
                    break;
                default:
                    System.out.println("Please try again");
            }
        }
        while (command != "0");
    }

    private void choiceMenu() {

        do {
            System.out.println("Please choose menu:");
            System.out.println("1: menu for admin");
            System.out.println("2: menu for user");
            System.out.println("0: exit");
            switch (command){
                case "1":
                    openUsersMenu();
                    break;
                case "2":
                    openAdminsMenu();
                    break;
                case "0":
                    System.out.println("Good bye! Have a nice day!");
                    break;
                default:
                    System.out.println("Please try again");
            }
        }
        while (command != "0");
    }

    private void openAdminsMenu() {
        do {
            System.out.println("Please choose option:");
            System.out.println("1: Users menu");
            System.out.println("2: Order menu");
            System.out.println("3: Products menu");
            System.out.println("0: exit");
            switch (command){
                case "1":
                    openUsersMenu();

                    break;
                case "2":
                    openAdminsMenu();
                    break;
                case "3":
                    System.out.println("1");
                    break;
                case "0":
                    System.out.println("Good bye! Have a nice day!");
                    break;
                default:
                    System.out.println("Please try again");
            }
        }
        while (command != "0");
    }

    private void openUsersMenu() {

    }
}

