package com.alasala.sis.studentInformationSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "staff_profile")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "gender_id")
    private int genderId;
    @Column(name = "email_prefix")
    private String emailPrefix;
}
