package com.challange.tenpo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import static com.challange.tenpo.config.Consts.*;

@Data
@AllArgsConstructor
public class UserDTO {

    @NotNull(message = USERNAME_NOT_NULL)
    @NotEmpty(message = USERNAME_NOT_EMPTY)
    @Size(min = 4, message = USERNAME_INVALID_SIZE)
    private String username;

    @NotNull(message = PASSWORD_NOT_NULL)
    @NotEmpty(message = PASSWORD_NOT_EMPTY)
    @Size(min = 4, message = PASSWORD_INVALID_SIZE)
    private String password;

    @Email(message = EMAIL_INVALID)
    @NotNull(message = EMAIL_NOT_NULL)
    @NotEmpty(message = EMAIL_NOT_EMPTY)
    private String mail;

}
