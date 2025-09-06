package com.alasala.sis.studentInformationSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "gender_id")
    private int genderId;
    @Column(name = "name")
    private String name;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "cnic")
    private String cnic;
    @Column(name = "age")
    private int age;
    @Column(name = "dobyear")
    private LocalDate dobYear;
}
