package com.project.nuvell.entity;

import com.project.nuvell.entity.value.*;
import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "tb_UserEscort")
@Table(uniqueConstraints = {@UniqueConstraint(name = "UniqueCpfAndEmailAndContact",columnNames = {"cpf", "email", "contact"})})
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
            @AttributeOverride(name = "value", column = @Column(name = "cpf", nullable = false, unique = true))
    })
    private Cpf cpf;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "Age", nullable = false))
    })
    private Age age;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "value", column = @Column(name = "Email", nullable = false, unique = true))
    )
    private Email email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "contact", nullable = false, unique = true))
    })
    private Contact contact;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Address address;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "gender", nullable = false))
    })
    private Gender gender;

    @Column(name = "created_At", updatable = false)
    private LocalDateTime created_At;


    public UserEscort() {
    }

    public UserEscort(FirstName firstName, LastName lastName, SocialName socialName , Cpf cpf,
                      Age age, Email email, Contact contact,Address address ,Gender gender, LocalDateTime createdAt) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.socialName = socialName;
        this.cpf = cpf;
        this.age = age;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.gender = gender;
        this.created_At = createdAt;
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
    public Address getAddress() {return address;}
    public String getGender() { return gender.getValue();}
    public String getEmail() { return email.getValue();}
    public LocalDateTime getCreatedAt() {return created_At;}

    public void updateFirstName(String newName){ firstName.updateFirstName(newName);}
    public void updateLastName(String newName){ lastName.updateLastName(newName);}
    public void updateSocialName(String newName){ socialName.updateSocialName(newName);}
    public void updateCpf(String newCpf) { cpf.updateValue(newCpf);}
    public void updateAge(Integer newAge){ age.updateAge(newAge);}
    public void updateEmail(String newEmail){ email.updateEmail(newEmail);}
    public void updateContact(String newContact){
        contact.updateContact(newContact);
    }
    public void updateGender(String newGender){
        gender.updateGender(newGender);
    }
    public void setAddress(Address address) {this.address = address;}

    @PrePersist
    protected void onCreate(){
        created_At = LocalDateTime.now();
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
