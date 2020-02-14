package com.example.myorder.api.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class CreateProductDto {

    @NotEmpty
    @ApiModelProperty(value = "${user.create.name}")
    private String name;

    @NotEmpty
    @Min(value = 1, message = "Valor minimo deve ser 1")
    @ApiModelProperty(value = "${user.create.value}")
    private Double value;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.restaurantId}")
    private Integer restaurantId;

    public String getName() {
        return name;
    }

    public CreateProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public CreateProductDto setValue(Double value) {
        this.value = value;
        return this;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public CreateProductDto setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }
}
