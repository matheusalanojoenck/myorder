package com.example.myorder.entities;

import com.example.myorder.enums.OrderStatusEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TOTAL_VALUE", nullable = false)
    private Double totalValue;

    @Column(name = "STATUS", nullable = false)
    private OrderStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    private Restaurant Restaurant;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User User;

    @OrderBy("id ASC")
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

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

    public Restaurant getRestaurant() {
        return Restaurant;
    }

    public Order setRestaurant(Restaurant restaurant) {
        Restaurant = restaurant;
        return this;
    }

    public User getUser() {
        return User;
    }

    public Order setUser(User user) {
        User = user;
        return this;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Order setItems(List<OrderItem> items) {
        this.items = items;
        return this;
    }
}
