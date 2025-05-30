package com.project.nuvell.entity.utiLS;

import jakarta.persistence.Embeddable;

import javax.management.InvalidAttributeValueException;

@Embeddable
public class AgeUtiLs {

    private Integer age;

    public AgeUtiLs() {
    }

    public AgeUtiLs(Integer age) throws InvalidAttributeValueException {
        if (validateAge(age))
            this.age = age;
    }

    public static boolean validateAge(Integer age) throws InvalidAttributeValueException {
        if (age < 18 || age >= 60){
            throw new InvalidAttributeValueException("A Idade proibida por lei");
        }
        return true;
    }

    public Integer getValue(){
        return age;
    }

    public void updateAge(Integer newAge){
        this.age = newAge;
    }

}
