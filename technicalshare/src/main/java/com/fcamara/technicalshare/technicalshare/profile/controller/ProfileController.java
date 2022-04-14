package com.fcamara.technicalshare.technicalshare.profile.controller;

import com.fcamara.technicalshare.technicalshare.profile.dto.ProfileDTO;
import com.fcamara.technicalshare.technicalshare.profile.dto.ProfileRegisterRequestDTO;
import com.fcamara.technicalshare.technicalshare.profile.service.ProfileService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
@SecurityRequirement(name = "security")
public class ProfileController {

    private final ProfileService profileService;
    
    @GetMapping("/findall")
    public ResponseEntity<Page<ProfileDTO>> findAllProfile(@RequestParam String toExcludeProfileEmail, @Nullable Pageable pageable) {
        return ResponseEntity.ok(profileService.findAllProfile(toExcludeProfileEmail, pageable));
    }

    @GetMapping("/findbyname")
    public ResponseEntity<Page<ProfileDTO>> findProfileByUserName (String name, String toExcludeProfileEmail, @Nullable Pageable pageable) {
        return ResponseEntity.ok(profileService.findProfileByUserName(name, toExcludeProfileEmail, pageable));
    }
    
    @GetMapping("/findprofile")
    public ResponseEntity<ProfileDTO> findProfileByEmail(@RequestParam String email) {
        return ResponseEntity.ok(profileService.findProfile(email));
    }

    @PostMapping("/register")
	public ResponseEntity<ProfileDTO> registerProfile(@Valid @RequestBody ProfileRegisterRequestDTO profileRegisterRequestDTO){
		return ResponseEntity.ok(profileService.registerProfile(profileRegisterRequestDTO));
	}

    @GetMapping("/findbyskill")
    public ResponseEntity<Page<ProfileDTO>> findProfilesBySkill(@Nullable @RequestParam String firstSkill, @Nullable @RequestParam String secondSkill, @Nullable @RequestParam String filterXP, @RequestParam String toExcludeProfileEmail, @Nullable Pageable pageable) {
        return ResponseEntity.ok(profileService.findProfilesBySkill(firstSkill, secondSkill, filterXP, pageable, toExcludeProfileEmail));
    }

}