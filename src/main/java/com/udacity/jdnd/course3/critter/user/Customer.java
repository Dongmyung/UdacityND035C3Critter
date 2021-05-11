package com.udacity.jdnd.course3.critter.user;


import com.udacity.jdnd.course3.critter.pet.Pet;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized
    private String name;
    @Column(name = "phone")
    private String phoneNumber;
    private String notes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "owner")
    private List<Pet> pets = new ArrayList<>();

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

}
