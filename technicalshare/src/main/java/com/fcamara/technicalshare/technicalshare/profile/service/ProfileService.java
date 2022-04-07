package com.fcamara.technicalshare.technicalshare.profile.service;

import com.fcamara.technicalshare.technicalshare.links.service.LinksService;
import com.fcamara.technicalshare.technicalshare.profile.dto.ProfileDTO;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import com.fcamara.technicalshare.technicalshare.profile.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final LinksService linksService;

    public ProfileDTO findProfile (String email) {
        return ProfileDTO.convertToDTO(profileRepository.findProfileByEmail(email));
    }

    public ProfileDTO registerProfile(ProfileDTO profileDTO) {

        Profile newProfile = profileRepository.save(ProfileDTO.convertToModel(profileDTO));

        newProfile.getLinksList().addAll(profileDTO.getLinksListDTO()
                .stream()
                .map(newLink -> linksService.registerLink(newLink, newProfile))
                .collect(Collectors.toList())
        );


        return ProfileDTO.convertToDTO(newProfile);
    }

    public List<ProfileDTO> findAllProfile() {
        return profileRepository.findAll().stream().map(ProfileDTO::convertToDTO).collect(Collectors.toList());
    }
}
