package com.fcamara.technicalshare.technicalshare.academiceducation.model;

import java.time.LocalDate;

import com.fcamara.technicalshare.technicalshare.profile.model.Profile;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
	@JoinColumn(name = "id_profile")
	private Profile profileAcademic;
    
}
