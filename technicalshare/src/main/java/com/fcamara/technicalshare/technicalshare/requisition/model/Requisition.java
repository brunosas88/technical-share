package com.fcamara.technicalshare.technicalshare.requisition.model;

import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
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
@Entity(name = "requisition")
public class Requisition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "required_username")
    private String requiredUserName;

    @Column(name = "subject")
    private String subject;

    @Column(name = "key_words")
    private String keyWords;

    @Column(name = "urgency")
    private Boolean urgency;

    @Column(name = "message")
    private String message;
    
    @ManyToMany(mappedBy = "mentoringListReceived")
    private List<Profile> apprenticeList = new ArrayList<>();

    @ManyToMany(mappedBy = "mentoringListGiven")
    private List<Profile> mentorList = new ArrayList<>();
}
