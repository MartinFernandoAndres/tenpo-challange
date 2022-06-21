package com.challange.tenpo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AccessTokenDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String token;

}