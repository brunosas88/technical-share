package com.fcamara.technicalshare.technicalshare.user.service;


import com.fcamara.technicalshare.technicalshare.authorities.model.Authority;
import com.fcamara.technicalshare.technicalshare.authorities.repository.AuthorityRepository;
import com.fcamara.technicalshare.technicalshare.authorities.service.AuthorityService;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;

import com.fcamara.technicalshare.technicalshare.user.dto.UserDTO;
import com.fcamara.technicalshare.technicalshare.user.dto.UserLoginDTO;
import com.fcamara.technicalshare.technicalshare.user.dto.UserResponseDTO;
import com.fcamara.technicalshare.technicalshare.user.model.User;
import com.fcamara.technicalshare.technicalshare.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;


    public void registerUser(UserDTO userDTO, Profile newProfile) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User newUser = userRepository.save(UserDTO.convertToModel(userDTO, newProfile));
        userDTO.getRoles().forEach(roles -> authorityService.saveAuthority(newUser, roles));
    }

    public UserResponseDTO login(UserLoginDTO userLoginDTO) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<User> userBD = Optional.of(userRepository.findByUserName(userLoginDTO.getUserName()).orElseThrow(() -> new NullPointerException("Usuário não encontrado")));
        if ( (userBD.isPresent()) && (encoder.matches(userLoginDTO.getPassword(), userBD.get().getPassword())) ){
            String authentication = userBD.get().getUserName() + ":" + userBD.get().getPassword();
            byte[] encodedAuthentication = Base64.encodeBase64(authentication.getBytes(Charset.forName("US-ASCII")));
            String headerAuthentication = "Basic " + new String(encodedAuthentication);
            return new UserResponseDTO(headerAuthentication, userLoginDTO.getUserName());
        } else {
            throw new NullPointerException("Senha inválida");
        }
    }
}
