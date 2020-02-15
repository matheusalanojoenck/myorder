package com.example.myorder.api.controllers;


import com.example.myorder.api.RestPath;
import com.example.myorder.api.dto.CreateOrderDto;
import com.example.myorder.api.dto.OrderResponseDto;
import com.example.myorder.api.dtos.CreateProductDto;
import com.example.myorder.api.dtos.ProductResponseDto;
import com.example.myorder.entities.Order;
import com.example.myorder.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("OrderController")
@RequestMapping(RestPath.BASE_PATH + "/order")
@Api(tags = "Pedidos")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    @ApiResponses({
            @ApiResponse(code = 201, message = "Pedido criado!", response = OrderResponseDto.class)
    })
    public OrderResponseDto create(@RequestBody @Valid CreateOrderDto createOrderDto) {
        return orderService.create(createOrderDto);
    }

}
