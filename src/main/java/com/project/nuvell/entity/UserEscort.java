package com.project.nuvell.entity;

import com.project.nuvell.entity.utiLS.AgeUtiLs;
import com.project.nuvell.entity.utiLS.CpfUtiLS;
import com.project.nuvell.entity.utiLS.GenderUtils;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity(name = "tb_UserEscort")
public class UserEscort implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String fullName;

    @Embedded
    @Column(nullable = false)
    private CpfUtiLS cpf;

    @Embedded
    @Column(nullable = false)
    private AgeUtiLs age;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String state;

    @Embedded
    @Column(nullable = false)
    private GenderUtils gender;


    public UserEscort() {
    }

    public UserEscort(Long id, String fullName, CpfUtiLS cpf, AgeUtiLs age, String email, String contact, String state, GenderUtils gender) {
        Id = id;
        this.fullName = fullName;
        this.cpf = cpf;
        this.age = age;
        this.email = email;
        this.contact = contact;
        this.state = state;
        this.gender = gender;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpf() {
        return this.cpf.getValue();
    }

    public void updateCpf(String newCpf) {
        cpf.updateValue(newCpf);

        getCpf();
    }

    public Integer getAge() {
        return this.age.getValue();
    }

    public void updateAge(Integer newAge){
        age.updateAge(newAge);

        getAge();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGender() {
        return gender.getValue();
    }

    public void updateGender(GenderUtils newGender){
        if (newGender == null){
            throw  new IllegalArgumentException("Dont be null");
        }
        this.gender = newGender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEscort that = (UserEscort) o;
        return Objects.equals(Id, that.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
