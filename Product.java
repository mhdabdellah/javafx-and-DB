/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Prof-Virus
 */
public class Product {
    private String product;
    private int qty;
    private double price;

    public Product(String product, int qty, double price) {
        this.product = product;
        this.qty = qty;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }
    
    
}
