package com.entities;

public class Product {

    private Long id;
    private String name;
    private double price;
    private Category category_id;

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    public Product(Long id, String name, double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category_id = category;
    }

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category_id = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category_id;
    }

    public void setCategory(Category category) {
        this.category_id = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category_id +
                '}';
    }
}
