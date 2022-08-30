package com.company.service;

import com.company.dao.ProductRepository;
import com.company.view.product.Gender;
import com.company.view.product.Product;
import com.company.view.product.Size;

import java.util.List;
import java.util.Scanner;

public class ProductService {

    private ProductRepository productRepository;
    private Scanner scanner = new Scanner(System.in);

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void editProduct() {
        System.out.println("Please write article of product");
        Integer article = scanner.nextInt();

        Product product = productRepository.findProduct(article);
        if (product == null) {
            System.out.println("Please, try again.");
            editProduct();
        } else {
            System.out.println("Choose option, which you want edit: ");
            System.out.println("1 - gender");
            System.out.println("2 - description");
            System.out.println("3 - color");
            System.out.println("4 - size");
            System.out.println("5 - price");
            editProductsOption(product);
        }
    }

    private void editProductsOption(Product product) {
        if (scanner.nextLine() == "1") {
            product.setKind(getNewGenderFromAdmin());
        } else if (scanner.nextLine() == "2") {
            System.out.println("Please write description of product");
            product.setDescription(scanner.nextLine());
        } else if (scanner.nextLine() == "3") {
            System.out.println("Please write color of product");
            product.setColor(scanner.nextLine());
        } else if (scanner.nextLine() == "4") {
            product.setSize(getNewSizeFromAdmin());
        } else if (scanner.nextLine() == "5") {
            System.out.println("Please write price of product");
            product.setPrice(scanner.nextInt());
        } else {
            System.out.println("Please, make your choice");
            editProductsOption(product);
        }
    }

    public void addProduct() {
        System.out.println("Please write article of product");
        Integer article = scanner.nextInt();

        Product product = productRepository.findProduct(article);
        if (product == null) {
            Gender gender = getNewGenderFromAdmin();
            System.out.println("Please write description of product");
            String description = scanner.nextLine();
            System.out.println("Please write color of product");
            String color = scanner.nextLine();
            Size size = getNewSizeFromAdmin();
            System.out.println("Please write price of product");
            Integer price = scanner.nextInt();
            productRepository.addProduct(article, gender, description, color, size, price);
        } else {
            System.out.println(article + " exist. You can try again");
            addProduct();
        }
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public Product findProduct(Integer article) {
        return productRepository.findProduct(article);
    }

    private Size getNewSizeFromAdmin() {
        Size size = null;
        System.out.println("Size: press 1 to choose S, 2 - M, 3 - L");
        Integer result = scanner.nextInt();
        if (result == 1) {
            size = Size.S;
        } else if (result == 2) {
            size = Size.M;
        } else if (result == 3) {
            size = Size.L;
        } else getNewSizeFromAdmin();
        return size;
    }

    private Gender getNewGenderFromAdmin() {

        Gender gender = null;
        System.out.println("Gender: press 1 to choose MALE or 2 - FEMALE");
        Integer result = scanner.nextInt();
        if (result == 1) {
            gender = Gender.MALE;
        } else if (result == 2) {
            gender = Gender.FEMALE;
        } else getNewGenderFromAdmin();
        return gender;
    }
}
