package com.fcamara.technicalshare.technicalshare.profession.model;


import javax.persistence.*;
<<<<<<< HEAD
=======

import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
>>>>>>> c1b9ea98487012ead47a180fd1e6065e53c52a4c

import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="profession")
public class Profession {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="occupation")
	private String occupation;

	@Column(name="duration")
	private Integer duration;

	@Column(name="description")
	private String description;

	@Column(name="experience_level")
	private String experienceLevel;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private Profile profileProfession;
<<<<<<< HEAD
=======
	
>>>>>>> c1b9ea98487012ead47a180fd1e6065e53c52a4c

}
