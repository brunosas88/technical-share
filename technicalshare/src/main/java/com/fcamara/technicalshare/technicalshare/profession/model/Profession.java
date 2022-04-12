package com.fcamara.technicalshare.technicalshare.profession.model;


import javax.persistence.*;

import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

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

	@Column(name="start_date")
	private LocalDate startDate;

	@Column(name="final_date")
	private LocalDate finalDate;

	@Column(name="description")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name="experience_level")
	private ExperienceLevelEnum experienceLevel;

	@ManyToOne
	@JoinColumn(name = "id_profile")
	private Profile profileProfession;

}
