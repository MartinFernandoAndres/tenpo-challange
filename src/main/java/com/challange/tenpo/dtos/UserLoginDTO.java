package com.challange.tenpo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginDTO {

    private String username;
    private String password;

}
