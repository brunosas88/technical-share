package com.fcamara.technicalshare.technicalshare.contact.model;

import com.fcamara.technicalshare.technicalshare.requisition.model.Requisition;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "contact")
    private String contact;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "id_requisition")
    private Requisition requisition;
}
