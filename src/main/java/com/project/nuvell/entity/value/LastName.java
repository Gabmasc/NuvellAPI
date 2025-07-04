package com.project.nuvell.entity.value;

import jakarta.persistence.Embeddable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class LastName {

    private String lastname;

    public LastName() {
    }

    public LastName(String lastname) {
        validateName(lastname);
        this.lastname = lastname;
    }

    public void validateName(String nameInput){
        if (nameInput == null || nameInput.isEmpty()){
            throw new IllegalArgumentException("Null camp is not allowed");
        }
        Pattern p = Pattern.compile("^.?[a-zA-Z]+.$");
        Matcher m = p.matcher(nameInput);
        if (!m.matches()){
            throw new IllegalArgumentException("Invalid Input");
        }

        this.lastname = nameInput;
    }

    public String getValue(){
        return lastname;
    }

    public void updateLastName(String newName){
        validateName(newName);
        this.lastname = newName;
    }
}
