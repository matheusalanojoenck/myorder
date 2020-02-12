package com.example.myorder.api.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

public class UserResponseDto {

    @NotEmpty
    @ApiModelProperty(value = "${user.create.id}")
    private String id;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.name}")
    private String name;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.phone}")
    private String phone;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.email}")
    private String email;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.address}")
    private String address;


}
