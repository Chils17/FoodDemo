package com.example.chiragpatel.fooddemo.model;

/**
 * Created by chiragpatel on 04/06/17.
 */

public class Food {
    private int img;
    private String name;
    private String price;

    public Food(int img, String name, String price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
