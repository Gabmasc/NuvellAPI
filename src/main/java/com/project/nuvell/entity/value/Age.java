package com.project.nuvell.entity.value;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.project.nuvell.infra.exception.InvalidAgeException;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;
import java.time.Period;

@Embeddable
public class Age {

    private Integer age;

    public Age() {
    }

    public Age(Integer age) {
        validateAge(age);
        this.age = age;
    }

    public void validateAge(Integer age){
        if (age == null ){
            throw new IllegalArgumentException("The camp age cannot be null");
        }
        if (age < 18 || age > 55){
            throw new InvalidAgeException("The age: " + age + " not permitted");
        }
        this.age = age;
    }

    public Integer getValue(){
        return age;
    }

    public void updateAge(Integer newAge){
        validateAge(newAge);
        this.age = newAge;
    }

    @Override
    public String toString() {
        return "Age{" +
                "age=" + age +
                '}';
    }
}
