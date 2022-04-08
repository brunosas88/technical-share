package com.fcamara.technicalshare.technicalshare.profile.model;

import com.fcamara.technicalshare.technicalshare.academiceducation.model.AcademicEducation;
import com.fcamara.technicalshare.technicalshare.links.model.Links;
import com.fcamara.technicalshare.technicalshare.profession.model.Profession;
import com.fcamara.technicalshare.technicalshare.skill.model.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "bio")
    private String bio;

    @OneToMany( mappedBy = "profileLink")
    private List<Links> linksList = new ArrayList<>();

    @OneToMany( mappedBy = "profileProfession")
    private List<Profession> professionList = new ArrayList<>();

    @OneToMany( mappedBy = "profileAcademic")
    private List<AcademicEducation> academicEducationList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_skill_expertise",
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_skill")}
    )
    private List<Skill> expertiseList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_skill_interests",
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_skill")}
    )
    private List<Skill> interestsList = new ArrayList<>();
}
