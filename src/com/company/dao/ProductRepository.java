package com.company.dao;

import com.company.view.product.*;

import java.util.*;

public class ProductRepository {

    Map<Integer, Product> productMap = new HashMap<>();

    public void createProducts() {
        productMap.put(123456, new Product(123456, Gender.MALE, "Shirt", "grey", Size.L, 200));
        productMap.put(123411, new Product(123411, Gender.MALE, "TShirt", "blue", Size.M, 200));
        productMap.put(123412, new Product(123412, Gender.FEMALE, "Shirt", "blue", Size.M, 300));
        productMap.put(123413, new Product(123413, Gender.FEMALE, "TShirt", "blue", Size.S, 300));
        productMap.put(123415, new Product(123415, Gender.MALE, "Trousers", "blue", Size.L, 400));
        productMap.put(123416, new Product(123416, Gender.MALE, "Trousers", "blue", Size.S, 400));
        productMap.put(123457, new Product(123457, Gender.FEMALE, "Pants", "grey", Size.L, 250));
        productMap.put(123410, new Product(123410, Gender.FEMALE, "Shoes", "blue", Size.M, 250));
    }

    public void addProduct(Integer article, Gender gender, String description, String color, Size size, Integer price) {
        productMap.put(article, new Product(article, gender, description, color, size, price));
    }

    public List<Product> getProducts() {
        return new ArrayList<>(productMap.values());
    }

    public Product findProduct(Integer article) {
        Product product = productMap.get(article);
        return product;
    }
}
