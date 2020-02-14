package com.example.myorder.entities;

import com.example.myorder.enums.OrderStatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "USER_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TOTAL_VALUE", nullable = false)
    private Double totalValue;

    @Column(name = "STAUTS", nullable = false)
    private OrderStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    private Restaurant Restaurant;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User User;

    public Integer getId() {
        return id;
    }

    public Order setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public Order setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public Order setStatus(OrderStatusEnum status) {
        this.status = status;
        return this;
    }

    public com.example.myorder.entities.Restaurant getRestaurant() {
        return Restaurant;
    }

    public Order setRestaurant(com.example.myorder.entities.Restaurant restaurant) {
        Restaurant = restaurant;
        return this;
    }

    public com.example.myorder.entities.User getUser() {
        return User;
    }

    public Order setUser(com.example.myorder.entities.User user) {
        User = user;
        return this;
    }
}
