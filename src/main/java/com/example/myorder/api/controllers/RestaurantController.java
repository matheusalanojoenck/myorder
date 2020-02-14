package com.example.myorder.api.controllers;

import com.example.myorder.api.RestPath;
import com.example.myorder.api.dto.CreateRestaurantDto;
import com.example.myorder.api.dto.RestaurantResponseDto;
import com.example.myorder.services.RestaurantService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("RestauranteControllerV1")
@RequestMapping(RestPath.BASE_PATH + "/restaurante")
@Api(tags = "Restaurantes")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody @Valid CreateRestaurantDto createRestaurantDto){
            restaurantService.createRestaurant(createRestaurantDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public RestaurantResponseDto get(@RequestParam @Param("id") Integer id){
        return restaurantService.getById(id);
    }
}
