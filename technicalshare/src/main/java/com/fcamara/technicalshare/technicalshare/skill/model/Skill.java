package com.fcamara.technicalshare.technicalshare.skill.model;

import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "skill")
    private String skill;

    @Column(name = "area")
    private String area;

    @ManyToMany(mappedBy = "expertiseList")
    private List<Profile> profileExpertiseList = new ArrayList<>();

    @ManyToMany(mappedBy = "interestsList")
    private List<Profile> profileInterestsList;
}
