package com.fcamara.technicalshare.technicalshare.profile.repository;

import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    Profile findProfileByEmail(String email);

    List<Profile> findProfileByUserNameIgnoreCaseContains(String userName, Sort sort);

}
