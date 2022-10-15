package com.mac.macstore.bll.models;

public class DeviceEntity{
    public int id;
    public String name;
    public int price;

    public DeviceEntity(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public DeviceEntity() {
    }
}
