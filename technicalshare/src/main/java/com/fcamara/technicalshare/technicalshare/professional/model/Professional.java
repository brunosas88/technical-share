package com.fcamara.technicalshare.technicalshare.Professional.model;

import com.fcamara.technicalshare.technicalshare.Profile.model.Profile;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="professional")
public class Professional {

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
	private Profile profile;
	

}
