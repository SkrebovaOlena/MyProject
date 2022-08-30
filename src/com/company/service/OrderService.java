package com.company.service;

import com.company.view.Order;
import com.company.view.OrderStatus;
import com.company.view.User;
import com.company.view.product.Product;

import java.util.Optional;
import java.util.Scanner;

public class OrderService {

    private ProductService productService;
    private UserService userService;
    private Scanner scanner = new Scanner(System.in);

    public OrderService(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    public boolean addProductToOrder(User user) {
        System.out.println("Please specify product article to add to order!");
        Integer article = scanner.nextInt();
        Product product = productService.findProduct(article);
        if (product == null) {
            System.out.println("Product with article " + article + " hasn't been found");
            return false;
        } else {
            for (Order order : user.getOrders()) {
                if (order.getStatus() == OrderStatus.DRAFT) {
                    order.getProducts().add(product);
                }
            }
            System.out.println("Product with article " + article + " has been successfully added to order");
            return true;
        }
    }

    public void checkout(User user) {
        for (Order order : user.getOrders()) {
            if (order.getStatus() == OrderStatus.DRAFT) {
                order.setStatus(OrderStatus.CHECKED_OUT);
            }
        }
        user.getOrders().add(new Order());
        System.out.println("Order successfully checked out!");
    }

    public void confirmOrder() {
        System.out.println("Please specify username to confirm order");
        String username = scanner.nextLine();

        User user = userService.getUserByUsername(username);

        if (user == null) {
            System.out.println("User with username " + username + " not found");
            return;
        }

        Optional<Order> order = user.getOrders().stream()
                .filter(o -> o.getStatus().equals(OrderStatus.CHECKED_OUT)).findFirst();

        if (order.isPresent()) {
            System.out.println("Order successfully confirmed");
            order.get().setStatus(OrderStatus.CONFIRMED);
        } else {
            System.out.println("User " + username + " doesn't have CHECKED_OUT orders");
        }
    }

    public void unconfirmOrder() {
        System.out.println("Please specify username to confirm order");
        String username = scanner.nextLine();

        User user = userService.getUserByUsername(username);

        if (user == null) {
            System.out.println("User with username " + username + " not found");
            return;
        }

        Optional<Order> order = user.getOrders().stream()
                .filter(o -> o.getStatus().equals(OrderStatus.CONFIRMED)).findFirst();

        if (order.isPresent()) {
            System.out.println("Order successfully unconfirmed");
            order.get().setStatus(OrderStatus.CHECKED_OUT);
        } else {
            System.out.println("User " + username + " doesn't have CONFIRMED orders");
        }
    }
}
