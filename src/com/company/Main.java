package com.company;

import com.company.service.UserRepository;
import com.company.view.Menu;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Internet-shop!");
        new Menu().startMenu();
    }
}
