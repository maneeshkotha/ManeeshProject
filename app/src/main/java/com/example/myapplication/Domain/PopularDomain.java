package com.example.myapplication.Domain;

import java.io.Serializable;

public class PopularDomain implements Serializable {

    private String title;

    private String description;

    private String picUrl;

    private int review;

    private double score;

    private double price;

    private int numberInCart;

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public int getReview() {
        return review;
    }

    public double getScore() {
        return score;
    }

    public double getPrice() {
        return price;
    }



    public PopularDomain(String title, String description, String picUrl, int review, double score,  double price) {
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.review = review;
        this.score = score;
        this.price = price;
    }
}
