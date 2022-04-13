package com.fcamara.technicalshare.technicalshare.profile.model;

import com.fcamara.technicalshare.technicalshare.academiceducation.model.AcademicEducation;
import com.fcamara.technicalshare.technicalshare.links.model.Links;
import com.fcamara.technicalshare.technicalshare.profession.model.Profession;
import com.fcamara.technicalshare.technicalshare.requisition.model.Requisition;
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
@Entity(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "bio")
    private String bio;

    @Column(name = "image")
    private String image;

    @OneToMany( mappedBy = "profileLink")
    private List<Links> linksList = new ArrayList<>();

    @OneToMany( mappedBy = "profileProfession")
    private List<Profession> professionList = new ArrayList<>();

    @OneToMany( mappedBy = "profileAcademic")
    private List<AcademicEducation> academicEducationList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "profile_skill_expertise",
            joinColumns = {@JoinColumn(name = "id_profile")},
            inverseJoinColumns = {@JoinColumn(name = "id_skill")}
    )
    private List<Skill> expertiseList = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "requisition_apprentice",
            joinColumns = {@JoinColumn(name = "id_profile")},
            inverseJoinColumns = {@JoinColumn(name = "id_requisition")}
    )
    private List<Requisition> mentoringListReceived = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "requisition_mentor",
            joinColumns = {@JoinColumn(name = "id_profile")},
            inverseJoinColumns = {@JoinColumn(name = "id_requisition")}
    )
    private List<Requisition> mentoringListGiven = new ArrayList<>();



}
