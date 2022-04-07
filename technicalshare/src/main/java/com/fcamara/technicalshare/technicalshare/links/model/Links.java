package com.fcamara.technicalshare.technicalshare.links.model;

import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    @JoinColumn(name = "id_profile")
    private Profile profileLink;

}
