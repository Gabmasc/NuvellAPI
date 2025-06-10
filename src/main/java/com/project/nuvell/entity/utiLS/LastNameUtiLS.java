package com.project.nuvell.entity.utiLS;

import jakarta.persistence.Embeddable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class LastNameUtiLS {

    private String lastname;

    public LastNameUtiLS() {
    }

    public LastNameUtiLS(String lastname) {
        validateName(lastname);
        this.lastname = lastname;
    }

    public void validateName(String nameInput){
        Pattern p = Pattern.compile("^.?[a-zA-Z]+.$");
        Matcher m = p.matcher(nameInput);

        if (nameInput.isEmpty()){
            throw new IllegalArgumentException("Null camp is not allowed");
        }
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
