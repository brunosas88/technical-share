package com.fcamara.technicalshare.technicalshare.user.model;


import com.fcamara.technicalshare.technicalshare.authorities.model.Authority;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class User {
    @Id
    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(mappedBy = "user")
    private List<Authority> authorities = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_profile")
    private Profile userProfile;


}
