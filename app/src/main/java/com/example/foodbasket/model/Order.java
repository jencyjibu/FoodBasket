package com.example.foodbasket.model;

public class Order {
    private Integer orderid;
    private Dish ordredDish;
    private User buyer;
    private Integer quantity;
    private String status;
    private String statusDateTime;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Dish getOrdredDish() {
        return ordredDish;
    }

    public void setOrdredDish(Dish ordredDish) {
        this.ordredDish = ordredDish;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDateTime() {
        return statusDateTime;
    }

    public void setStatusDateTime(String statusDateTime) {
        this.statusDateTime = statusDateTime;
    }
}
