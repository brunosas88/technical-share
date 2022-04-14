package com.fcamara.technicalshare.technicalshare.user.controller;

import com.fcamara.technicalshare.technicalshare.user.dto.UserDTO;
import com.fcamara.technicalshare.technicalshare.user.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@SecurityRequirement(name = "security")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody UserDTO userDTO) {
        userService.registerUser(userDTO, null);
    }
}
