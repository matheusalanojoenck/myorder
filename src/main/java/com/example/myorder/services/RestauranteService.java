package com.example.myorder.services;

import com.example.myorder.api.dto.CreateRestaurantDto;
import com.example.myorder.api.dto.RestaurantResponseDto;
import com.example.myorder.entities.Restaurante;
import com.example.myorder.repositories.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public void createRestaurant(CreateRestaurantDto createRestaurantDto) {
        //TODO validações

        Restaurante restaurant = new Restaurante()
        .setEmail(createRestaurantDto.getEmail())
        .setName(createRestaurantDto.getName())
        .setPhone(createRestaurantDto.getPhone());

        restauranteRepository.save(restaurant);
    }

    public RestaurantResponseDto getById(Integer id) {

        Optional<Restaurante> optional = restauranteRepository.findById(id);
        Restaurante restaurant = optional.get();
        return new RestaurantResponseDto()
                .setEmail(restaurant.getEmail())
                .setId(restaurant.getId())
                .setName(restaurant.getName())
                .setPhone(restaurant.getPhone());

    }
}
