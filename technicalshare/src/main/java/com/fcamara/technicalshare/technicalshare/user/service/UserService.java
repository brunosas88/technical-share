package com.fcamara.technicalshare.technicalshare.user.service;


import com.fcamara.technicalshare.technicalshare.authorities.model.Authority;
import com.fcamara.technicalshare.technicalshare.authorities.repository.AuthorityRepository;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;

import com.fcamara.technicalshare.technicalshare.user.dto.UserDTO;
import com.fcamara.technicalshare.technicalshare.user.model.User;
import com.fcamara.technicalshare.technicalshare.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;


    public void registerUser(UserDTO userDTO, Profile newProfile) {


        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User newUser = userRepository.save(UserDTO.convertToModel(userDTO, newProfile));
        userDTO.getRoles().forEach(roles -> saveAuthority(newUser, roles));

    }

    public void saveAuthority(User user, String role) {
        Authority authority = Authority.convert(user, "ROLE_" + role);
        authorityRepository.save(authority);
    }

}
