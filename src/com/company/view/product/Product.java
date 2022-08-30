package com.company.view.product;

public class Product {

    private Integer article;
    private Gender kind;
    private String description;
    private String color;
    private Size size;
    private Integer price;

    public Product(Integer article, Gender kind, String description, String color, Size size, Integer price) {
        this.article = article;
        this.kind = kind;
        this.description = description;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public Gender getKind() {
        return kind;
    }

    public void setKind(Gender kind) {
        this.kind = kind;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getArticle() {
        return article;
    }

    public void setArticle(Integer article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "article=" + article +
                ", kind=" + kind +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", size=" + size +
                ", price=" + price;
    }
}