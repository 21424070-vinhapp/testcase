package com.example.myapplication;

import java.io.Serializable;

public class Welcome9 implements Serializable {
    private String product;
    private long price;
    private Specifications specifications;

    public String getProduct() { return product; }
    public void setProduct(String value) { this.product = value; }

    public long getPrice() { return price; }
    public void setPrice(long value) { this.price = value; }

    public Specifications getSpecifications() { return specifications; }
    public void setSpecifications(Specifications value) { this.specifications = value; }

    @Override
    public String toString() {
        return "Welcome9{" +
                "product='" + product + '\'' +
                ", price=" + price +
                ", specifications=" + specifications +
                '}';
    }
}