package com.company.view;

import com.company.dao.ProductRepository;
import com.company.dao.UserRepository;
import com.company.service.OrderService;
import com.company.service.ProductService;
import com.company.service.UserService;
import com.company.view.product.Product;

import java.util.Scanner;

public class Menu {

    private UserService userService;
    private ProductService productService;
    private OrderService orderService;

    private Scanner scanner = new Scanner(System.in);

    public Menu() {
        UserRepository userRepository = new UserRepository();
        userRepository.ñreateUsers();

        ProductRepository productRepository = new ProductRepository();
        productRepository.createProducts();

        this.userService = new UserService(userRepository);
        this.productService = new ProductService(productRepository);
        this.orderService = new OrderService(this.productService, this.userService);
    }

    public void startMenu() {

        String command;
        do {
            System.out.println("Please make your choice");
            System.out.println("1: registration");
            System.out.println("2: authentication");
            System.out.println("0: exit");

            command = scanner.nextLine();
            User user;
            switch (command) {
                case "1":
                    user = userService.userRegistration();
                    if (user == null) {
                        startMenu();
                    } else {
                        openClientsMenu(user);
                    }
                    break;
                case "2":
                    user = userService.loginUser();
                    if (user == null) {
                        startMenu();
                    } else if (user.isAdmin()) {
                        openAdminsMenu(user);
                    } else {
                        openClientsMenu(user);
                    }
                    break;
                case "0":
                    System.out.println("Good bye! Have a nice day!");
                    break;
                default:
                    System.out.println("Please try again");
            }
        }
        while (!command.equals("0"));
    }

    private void openClientsMenu(User user) {
        String command;
        do {
            System.out.println("Please choose option:");
            System.out.println("1: List products");
            System.out.println("2: Add specific product article to order");
            System.out.println("3: Search specific product by article");
            System.out.println("4: Order checkout");
            System.out.println("5: See my orders");
            System.out.println("0: exit");
            command = scanner.nextLine();
            switch (command) {
                case "1":
                    productService.getProducts().forEach(System.out::println);
                    break;
                case "2":
                    orderService.addProductToOrder(user);
                    break;
                case "3":
                    Product product = productService.findProduct(scanner.nextInt());
                    if (product == null) {
                        System.out.println("No product has been found");
                    } else {
                        System.out.println("Product was found: " + product);
                    }
                    break;
                case "4":
                    orderService.checkout(user);
                    break;
                case "5":
                    user.getOrders().forEach(o -> System.out.println(o));
                    break;
                case "0":
                    System.out.println("Good bye! Have a nice day!");
                    break;
                default:
                    System.out.println("Please try again");
            }
        }
        while (!command.equals("0"));
    }

    private void openAdminsMenu(User user) {
        String command;
        do {
            System.out.println("Please choose option:");
            System.out.println("1: Block/unblock user");
            System.out.println("2: Confirm order");
            System.out.println("3: Unconfirm order");
            System.out.println("4: Edit existing product");
            System.out.println("5: Add new product");
            System.out.println("0: exit");
            command = scanner.nextLine();
            switch (command) {
                case "1":
                    userService.blockUnblockUser();
                    break;
                case "2":
                    orderService.confirmOrder();
                    break;
                case "3":
                    orderService.unconfirmOrder();
                    break;
                case "4":
                    productService.editProduct();
                    break;
                case "5":
                    productService.addProduct();
                    break;
                case "0":
                    System.out.println("Good bye! Have a nice day!");
                    break;
                default:
                    System.out.println("Please try again");
            }
        }
        while (!command.equals("0"));
    }
}

