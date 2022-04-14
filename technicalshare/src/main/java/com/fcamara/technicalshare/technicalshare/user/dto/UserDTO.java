package com.fcamara.technicalshare.technicalshare.user.dto;

import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import com.fcamara.technicalshare.technicalshare.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank
    private String userName;
    @NotBlank
    private String password;

    private List<String> roles;

    public static User convertToModel(UserDTO dto, Profile profile) {
        User user = new User();
        user.setEnabled(true);
        user.setPassword(dto.getPassword());
        user.setUserName(dto.getUserName());
        user.setUserProfile(profile);
        return user;
    }
}
