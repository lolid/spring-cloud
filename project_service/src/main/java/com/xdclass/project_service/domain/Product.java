package com.xdclass.project_service.domain;

import java.io.Serializable;

/**
 * 商品实体类
 */
public class Product implements Serializable {

    private int id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 价格,分为单位
      */

    private int price;

    /**
     * 库存
     */
    private int store;


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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public Product(int id, String name, int price, int store) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.store = store;
    }

    public Product() {

    }
}
