package com.example.myorder.api.dto;

import com.example.myorder.enums.OrderStatusEnum;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class OrderResponseDto {

    @ApiModelProperty(value = "${order.response.id}")
    private Integer id;

    @ApiModelProperty(value = "${order.response.totalValue}")
    private Double totalValue;

    @ApiModelProperty(value = "${order.response.orderStatus}")
    private OrderStatusEnum orderStatus;

    @ApiModelProperty(value = "${order.response.userResponse}")
    private UserResponseDto userResponse;

    @ApiModelProperty(value = "${order.response.items}")
    private List<OrderItemDto> items;

    public Integer getId() {
        return id;
    }

    public OrderResponseDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public OrderResponseDto setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public OrderResponseDto setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public UserResponseDto getUserResponse() {
        return userResponse;
    }

    public OrderResponseDto setUserResponse(UserResponseDto userResponse) {
        this.userResponse = userResponse;
        return this;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public OrderResponseDto setItems(List<OrderItemDto> items) {
        this.items = items;
        return this;
    }
}
