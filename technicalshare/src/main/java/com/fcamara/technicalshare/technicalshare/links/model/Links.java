package com.fcamara.technicalshare.technicalshare.links.model;

import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "links")
public class Links {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "domain")
    private String domain;

    @Column(name = "link")
    private String link;

    @Column(name = "disponibility")
    private Boolean disponibility;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Profile profile;


}
