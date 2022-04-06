package com.fcamara.technicalshare.technicalshare.academicEducation.model;

import java.time.LocalDate;

import com.fcamara.technicalshare.technicalshare.profile.model.Profile;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="academic_education")
public class AcademicEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="course")
    private String course;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="final_date")
    private LocalDate finalDate;

    @Column(name = "institution")
    private String institution;

    @ManyToOne
	@JoinColumn(name = "id_user")
	private Profile profile;
    
}
