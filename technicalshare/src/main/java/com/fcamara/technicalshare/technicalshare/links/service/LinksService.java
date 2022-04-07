package com.fcamara.technicalshare.technicalshare.links.service;

import com.fcamara.technicalshare.technicalshare.links.dto.LinksDTO;
import com.fcamara.technicalshare.technicalshare.links.model.Links;
import com.fcamara.technicalshare.technicalshare.links.repository.LinksRepository;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinksService {

    private final LinksRepository linksRepository;

    public Links registerLink(LinksDTO linkDTO, Profile profile){
        Links newLink = new Links();
        newLink.setDomain(linkDTO.getDomain());
        newLink.setLink(linkDTO.getLink());
        newLink.setDisponibility(linkDTO.getDisponibility());
        newLink.setProfileLink(profile);
        return linksRepository.save(newLink);
    }
}
