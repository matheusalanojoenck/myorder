package com.example.myorder.services;

import com.example.myorder.api.dto.CreateOrderDto;
import com.example.myorder.api.dto.CreateOrderItemDto;
import com.example.myorder.api.dto.OrderResponseDto;
import com.example.myorder.entities.Order;
import com.example.myorder.entities.Product;
import com.example.myorder.enums.OrderStatusEnum;
import com.example.myorder.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    ProductService productService;

    public OrderResponseDto create(CreateOrderDto createOrderDto){
          Order order = createOrder(createOrderDto);

          order = orderRepository.save(order);

          return new OrderResponseDto()
                  .setId(order.getId())
                  .setOrderStatus(order.getStatus())
                  .setTotalValue(order.getTotalValue())
                  .setItems(orderItemService.biuldOrderItemDtos(order.getItems()));
    }

    private Order createOrder(CreateOrderDto createOrderDto){

        Order order = new Order();

        return order.setStatus(OrderStatusEnum.OPEN)
                .setRestaurant(restaurantService.findById(createOrderDto.getRestaurantId()))
                .setUser(userService.findById(createOrderDto.getUserId()))
                .setItems(orderItemService.createOrderItems(createOrderDto.getOrderItens(), order))
                .setTotalValue(calculateOrderTotalValuer(createOrderDto.getOrderItens()));
    }

    private Double calculateOrderTotalValuer(List<CreateOrderItemDto> itens){
        return itens.stream()
                .map(orderItemDto -> {
                    Product referenceProduct = productService.findByOd(orderItemDto.getProductId());

                    Double itemValue = referenceProduct.getValue() * orderItemDto.getQuantity();

                    return itemValue;
                }).reduce(0d, Double::sum);
    }
}
