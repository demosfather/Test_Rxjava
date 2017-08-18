package com.nby.test_rxjava.entity;

/**
 * Created by lenovo on 2017/7/20.
 */

public class Fruit {
    int image;
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fruit(int image, String name) {
        this.image = image;
        this.name = name;
    }
}
