package com.fcamara.technicalshare.technicalshare.user.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserLoginDTO {

    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
