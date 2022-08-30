package com.company.view;

import com.company.view.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private OrderStatus status = OrderStatus.DRAFT;
    private List<Product> products = new ArrayList<>();

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{ " +
                "status=" + status +
                ", products=" + products +
                " }";
    }
}
