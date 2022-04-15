package com.fcamara.technicalshare.technicalshare.authorities.service;

import com.fcamara.technicalshare.technicalshare.authorities.model.Authority;
import com.fcamara.technicalshare.technicalshare.authorities.repository.AuthorityRepository;
import com.fcamara.technicalshare.technicalshare.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorityService {

    private final AuthorityRepository authorityRepository;

    public void saveAuthority(User user, String role) {
        Authority authority = Authority.convert(user, "ROLE_" + role);
        authorityRepository.save(authority);
    }
}
