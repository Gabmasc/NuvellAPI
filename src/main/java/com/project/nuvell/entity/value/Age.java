package com.project.nuvell.entity.value;

import com.project.nuvell.infra.exception.InvalidAgeException;
import jakarta.persistence.Embeddable;

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
        if (age == null || age < 18 || age >= 60){
            throw new InvalidAgeException("Invalid age " + age);
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

}
