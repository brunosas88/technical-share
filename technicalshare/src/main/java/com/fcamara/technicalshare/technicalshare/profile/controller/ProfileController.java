package com.fcamara.technicalshare.technicalshare.profile.controller;

import com.fcamara.technicalshare.technicalshare.profile.dto.ProfileDTO;
import com.fcamara.technicalshare.technicalshare.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;
    
    @GetMapping("/all")
    public ResponseEntity<Page<ProfileDTO>> findAllProfile(Pageable pageable) {
        return ResponseEntity.ok(profileService.findAllProfile(pageable));
    }
    
    @GetMapping("/findprofile")
    public ResponseEntity<ProfileDTO> findProfile(@RequestParam String email) {
        return ResponseEntity.ok(profileService.findProfile(email));
    }

    @PostMapping
	public ResponseEntity<ProfileDTO> registerProfile(@RequestBody ProfileDTO profileDTO){
		return ResponseEntity.ok(profileService.registerProfile(profileDTO));
	}

}
