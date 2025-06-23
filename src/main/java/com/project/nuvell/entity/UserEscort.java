package com.project.nuvell.entity;

import com.project.nuvell.entity.utiLS.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "tb_UserEscort")
public class UserEscort implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "Firstname", nullable = false))
    private FirstName firstName;
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "value", column = @Column(name = "Lastname", nullable = false))
    )
    private LastName lastName;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "value", column = @Column(name = "Socialname", nullable = false))
    )
    private SocialName socialName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "cpf", nullable = false))
    })
    private Cpf cpf;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "age", nullable = false))
    })
    private Age age;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "value", column = @Column(name = "Email", nullable = false))
    )
    private Email email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "contact", nullable = false))
    })
    private Contact contact;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "state", nullable = false))
    })
    private State state;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "gender", nullable = false))
    })
    private Gender gender;


    public UserEscort() {
    }

    public UserEscort(FirstName firstName, LastName lastName, SocialName socialName , Cpf cpf,
                      Age age, Email email, Contact contact, State state, Gender gender) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.socialName = socialName;
        this.cpf = cpf;
        this.age = age;
        this.email = email;
        this.contact = contact;
        this.state = state;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName.getValue();
    }
    public String getLastName() { return lastName.getValue();}
    public String getSocialName() { return socialName.getValue();}
    public String getCpf() { return this.cpf.getValue();}
    public Integer getAge() { return this.age.getValue();}
    public String getContact() { return this.contact.getValue();}
    public String getState() { return state.getValue();}
    public String getGender() { return gender.getValue();}
    public String getEmail() { return email.getValue();}

    public void updateFirstName(String newName){ firstName.updateFirstName(newName);}
    public void updateLastName(String newName){ lastName.updateLastName(newName);}
    public void updateSocialName(String newName){ socialName.updateSocialName(newName);}
    public void updateCpf(String newCpf) { cpf.updateValue(newCpf);}
    public void updateAge(Integer newAge){ age.updateAge(newAge);}
    public void updateEmail(String newEmail){ email.updateEmail(newEmail);}
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
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
