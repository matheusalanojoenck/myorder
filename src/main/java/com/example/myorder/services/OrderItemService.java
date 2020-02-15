package com.example.myorder.services;

import com.example.myorder.api.dto.CreateOrderItemDto;
import com.example.myorder.api.dto.OrderItemDto;
import com.example.myorder.entities.Order;
import com.example.myorder.entities.OrderItem;
import com.example.myorder.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductService productService;

    public List<OrderItem> createOrderItems(List<CreateOrderItemDto> itens, Order order){
        return itens.stream()
                .map(orderItemDto -> buildOrderItem(orderItemDto, order))
                .collect(Collectors.toList());
    }

    public List<OrderItemDto> buildOrderItemDtos(List<OrderItem> orderItems) {
        return orderItems.stream().map(orderItem -> new OrderItemDto()
                .setId(orderItem.getId())
                .setQuantity(orderItem.getQuantity())
                .setProductResponse(productService.createProductResponseDto(orderItem.getProduct(), orderItem.getOrder().getRestaurant())))
                .collect(Collectors.toList());
    }

    private OrderItem buildOrderItem(CreateOrderItemDto orderItemDto, Order order){
        return new OrderItem()
                .setProduct(productService.findByOd(orderItemDto.getProductId()))
                .setOrder(order)
                .setQuantity(orderItemDto.getQuantity());
    }


}
