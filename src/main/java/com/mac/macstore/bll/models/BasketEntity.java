package com.mac.macstore.bll.models;

public class BasketEntity {
    public int product_id;
    public int user_id;
    public int count;

    public BasketEntity(int product_id, int user_id, int count) {
        this.product_id = product_id;
        this.user_id = user_id;
        this.count = count;
    }

    public BasketEntity() {
    }
}