package com.fcamara.technicalshare.technicalshare.requisition.model;

import com.fcamara.technicalshare.technicalshare.contact.model.Contact;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "requisition")
public class Requisition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uuid_requisition", unique = true)
    private UUID uuidRequisition;

    @Column(name = "username")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "required_username")
    private String requiredUserName;

    @Column(name = "required_user_email")
    private String requiredUserEmail;

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

    @OneToMany(mappedBy = "requisition")
    private List<Contact> contactList = new ArrayList<>();
}
