package com.challange.tenpo.controllers;

import com.challange.tenpo.dtos.AccessTokenDTO;
import com.challange.tenpo.dtos.UserDTO;
import com.challange.tenpo.dtos.UserLoginDTO;
import com.challange.tenpo.entitys.User;
import com.challange.tenpo.exceptions.UserAlreadyExistException;
import com.challange.tenpo.services.AuthService;
import com.challange.tenpo.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static com.challange.tenpo.config.Consts.USER_IS_ALREADY_REGISTERED_EXCEPTION;
import static com.challange.tenpo.config.Consts.EMAIL_IS_ALREADY_REGISTERED_EXCEPTION;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
@Api(tags = "Users")
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/singup")
    @ApiOperation(value = "User Register")
    public ResponseEntity<User> singUpUser(
            @ApiParam(value = "User to register", required = true)
            @Valid @RequestBody UserDTO userDTO) throws UserAlreadyExistException {
        if (userService.isUserRegistered(userDTO.getUsername().trim().toLowerCase())) {
            throw new UserAlreadyExistException(USER_IS_ALREADY_REGISTERED_EXCEPTION.concat(userDTO.getUsername()));
        } else if (userService.isEmailRegistered(userDTO.getMail().trim().toLowerCase())){
            throw new UserAlreadyExistException(EMAIL_IS_ALREADY_REGISTERED_EXCEPTION.concat(userDTO.getMail()));
        }
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/singup").toUriString());
        User user = new User(userDTO.getUsername().trim().toLowerCase(), userDTO.getPassword(), userDTO.getMail());
        return ResponseEntity.created(uri).body(userService.registerUser(user));
    }

    @PostMapping("/login")
    @ApiOperation(value = "User Login")
    public ResponseEntity<AccessTokenDTO> login(
            @ApiParam(value = "User Credentials", required = true)
            @Valid @RequestBody UserLoginDTO credentials) {
        Authentication auth = authService.authenticate(credentials.getUsername(), credentials.getPassword());
        return ResponseEntity.ok(authService.generateAccessToken(auth));
    }

    @GetMapping("/logout")
    @ApiOperation(value = "User Logout")
    public ResponseEntity<Map<String, String>> logout(
            @RequestHeader(required = true, value = "Authorization") String authHeader) {
        Map<String, String> logoutMsg = new HashMap<>();
        logoutMsg.put("message", String.format("User: %s logged out successfully.", authService.invalidateAccessToken(authHeader)));
        return ResponseEntity.ok(logoutMsg);
    }
}
