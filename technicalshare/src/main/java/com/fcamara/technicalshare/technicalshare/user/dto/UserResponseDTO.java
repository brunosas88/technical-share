package com.fcamara.technicalshare.technicalshare.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponseDTO {

    private String authentication;
    private String profileEmail;
}
