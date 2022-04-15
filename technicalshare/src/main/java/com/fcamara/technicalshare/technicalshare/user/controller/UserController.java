package com.fcamara.technicalshare.technicalshare.user.controller;

import com.fcamara.technicalshare.technicalshare.profile.dto.ProfileDTO;
import com.fcamara.technicalshare.technicalshare.user.dto.UserDTO;
import com.fcamara.technicalshare.technicalshare.user.dto.UserLoginDTO;
import com.fcamara.technicalshare.technicalshare.user.dto.UserResponseDTO;
import com.fcamara.technicalshare.technicalshare.user.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody UserDTO userDTO) {
        userService.registerUser(userDTO, null);
    }

    @PostMapping ("/login")
    public ResponseEntity<UserResponseDTO> loginUser (@RequestBody UserLoginDTO userLoginDTO) {
        return ResponseEntity.ok(userService.login(userLoginDTO));
    }
}
