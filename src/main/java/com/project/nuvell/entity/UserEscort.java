package com.project.nuvell.entity;

import com.project.nuvell.entity.utiLS.*;
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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "name", nullable = false))
    })
    private NameUtiLS fullName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "cpf", nullable = false))
    })
    private CpfUtiLS cpf;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "age", nullable = false))
    })
    private AgeUtiLs age;

    @Column(nullable = false)
    private String email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "contact", nullable = false))
    })
    private ContactUtiLs contact;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "state", nullable = false))
    })
    private StateUtiLS state;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "gender", nullable = false))
    })
    private GenderUtils gender;


    public UserEscort() {
    }

    public UserEscort(Long id, NameUtiLS fullName, CpfUtiLS cpf, AgeUtiLs age, String email, ContactUtiLs contact, StateUtiLS state, GenderUtils gender) {
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
        return fullName.getValue();
    }
    public String getCpf() {
        return this.cpf.getValue();
    }
    public Integer getAge() {
        return this.age.getValue();
    }
    public String getContact() { return this.contact.getValue();}
    public String getState() {
        return state.getValue();
    }
    public String getGender() {
        return gender.getValue();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    public void updateCpf(String newCpf) {
        cpf.updateValue(newCpf);
    }
    public void updateAge(Integer newAge){
        age.updateAge(newAge);
    }
    public void updateEmail(String newEmail){
    }public void updateName(String newName){
        fullName.updateName(newName);
    }
    public void updateContact(String newContact){
        contact.updateContact(newContact);
    }
    public void updateState(String newState){
        state.updateValue(newState);
    }
    public void updateGender(String newGender){
        gender.updateGender(newGender);
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
