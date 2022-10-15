package com.mac.macstore.bll.models;

public class ProductEntity {
    public int id;
    public String name;
    public int price;
    public int product_type_id;

    public ProductEntity(int id, String name, int price, int product_type_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.product_type_id = product_type_id;
    }

    public ProductEntity() {
    }
}
