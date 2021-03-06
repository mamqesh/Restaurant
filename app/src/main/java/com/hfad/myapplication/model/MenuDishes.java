package com.hfad.myapplication.model;

public class MenuDishes {
    int id, dish;
    String img, title, description, weight, price, color, text;

    public MenuDishes(int id, String img, String title, String description, String weight, String price, String color, String text, int dish) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.description = description;
        this.weight = weight;
        this.price = price;
        this.color = color;
        this.text = text;
        this.dish=dish;
    }

    public int getDish() {
        return dish;
    }

    public void setDish(int dish) {
        this.dish = dish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
