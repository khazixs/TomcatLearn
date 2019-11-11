package com.IceCoLa.domain;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import java.io.Serializable;

public class Purchaser implements Serializable {
    private int id;
    private String name;
    private String address;
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Purchaser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", product=" + product +
                '}';
    }
}
