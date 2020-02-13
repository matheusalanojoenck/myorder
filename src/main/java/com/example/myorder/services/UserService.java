package com.example.myorder.services;

import com.example.myorder.api.dto.CreateUserDto;
import com.example.myorder.api.dto.RestaurantResponseDto;
import com.example.myorder.api.dto.UserResponseDto;
import com.example.myorder.api.mappers.UserMapper;
import com.example.myorder.entities.Restaurant;
import com.example.myorder.entities.User;
import com.example.myorder.exceptions.AlreadyExistsException;
import com.example.myorder.exceptions.NotFoundException;
import com.example.myorder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDto create(CreateUserDto createUserDto){
        validateUserEmail(createUserDto.getEmail());

        User user = userRepository.save(createUser(createUserDto));

        return UserMapper.toResponseDto(user);
    }

    public UserResponseDto findById(Integer id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw  new NotFoundException("Não existe usuario com esse Id");
        }

        return UserMapper.toResponseDto(user.get());
    }

//    public List<UserResponseDto> listAll() {
//        List<User> users = userRepository.findAll();
//
//        users.stream().map(user -> new UserResponseDto()
//                    .setPhone(user.getPhone())
//                    .setEmail(user.getEmail())
//                    .setAddress(user.getAddress())
//                    .setName(user.getName())
//                    .collect(Collectors.toList());
//        );
//    }

    public List<UserResponseDto> listAll(){
        List<User> users = userRepository.findAll();
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();

        for (User user : users){
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setName(user.getName());
            userResponseDto.setAddress(user.getAddress());
            userResponseDto.setEmail(user.getEmail());
            userResponseDto.setPhone(user.getPhone());

            userResponseDtoList.add(userResponseDto);
        }

        return userResponseDtoList;
    }


    private User createUser(CreateUserDto createUserDto){
        return new User()
                .setName(createUserDto.getName())
                .setEmail(createUserDto.getEmail())
                .setAddress(createUserDto.getAddress())
                .setPassword(createUserDto.getPassword())
                .setPhone(createUserDto.getPhone());
    }

    private void validateUserEmail(String email){
        User user = userRepository.findByEmail(email);

        if (user != null) {
            throw new AlreadyExistsException("Já existe um usuário cadastrado com esse email");
        }
    }


}
