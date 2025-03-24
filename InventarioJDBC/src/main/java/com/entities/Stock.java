package com.entities;

import java.sql.Date;

public class Stock {

    private Long id;
    private int quantity;
    private Date date;
    private Product product;

    public Stock() {
    }

    public Stock(Long id, int quantity, Date date, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.date = date;
        this.product = product;
    }

    public Stock(int quantity, Date date, Product product) {
        this.quantity = quantity;
        this.date = date;
        this.product = product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", date=" + date +
                ", product=" + product +
                '}';
    }
}
