package com.marwan.SMA.model;

import jakarta.persistence.*;

@Entity //hibernate
@Table(name = "student")
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(name = "fg")
    private Long id;
    private String nom;
    private String prenom;
    private int age;
    private String sexe;
    private String school;
    private double anneeScolaire;

    // Default constructor
    public Student() {
    }

    // Constructor with all parameters
    public Student(Long id, String nom, String prenom, int age, String sexe, String school, double anneeScolaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
        this.school = school;
        this.anneeScolaire = anneeScolaire;
    }

    // Constructor without ID
    public Student(double anneeScolaire, String school, String sexe, int age, String prenom, String nom) {
        this.anneeScolaire = anneeScolaire;
        this.school = school;
        this.sexe = sexe;
        this.age = age;
        this.prenom = prenom;
        this.nom = nom;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(double anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }
}
