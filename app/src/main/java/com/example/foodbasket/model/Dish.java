package com.example.foodbasket.model;

import android.net.Uri;

public class Dish {

    private Integer dishid;
    private String name;
    private String description;
    private Integer maximumQuantity;
    private Integer price;
    private String orderByDate;
    private String readyDateTime;
     private User seller;
     private Uri dishImage;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setMaximumQuantity(Integer maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getOrderByDate() {
        return orderByDate;
    }

    public void setOrderByDate(String orderByDate) {
        this.orderByDate = orderByDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Integer getDishid() {
        return dishid;
    }

    public void setDishid(Integer dishid) {
        this.dishid = dishid;
    }



    public String getReadyDateTime() {
        return readyDateTime;
    }

    public void setReadyDateTime(String readyDateTime) {
        this.readyDateTime = readyDateTime;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Uri getDishImage() {
        return dishImage;
    }

    public void setDishImage(Uri dishImage) {
        this.dishImage = dishImage;
    }
}
