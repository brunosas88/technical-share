package com.fcamara.technicalshare.technicalshare.profile.controller;

import com.fcamara.technicalshare.technicalshare.profile.dto.ProfileDTO;
import com.fcamara.technicalshare.technicalshare.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/findprofile")
    public ResponseEntity<ProfileDTO> findProfile(@RequestParam String email) {
        return ResponseEntity.ok(profileService.findProfile(email));
    }

    @GetMapping
    public ResponseEntity<List<ProfileDTO>> findAllProfile() {
        return ResponseEntity.ok(profileService.findAllProfile());
    }

    @PostMapping
    public ResponseEntity<ProfileDTO> registerProfile(@RequestBody ProfileDTO profileDTO) {
        return ResponseEntity.ok(profileService.registerProfile(profileDTO));
    }

}
