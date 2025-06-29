package com.project.nuvell.entity.value;

import jakarta.persistence.Embeddable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class FirstName {

    private String firstname;

    public FirstName() {
    }

    public FirstName(String firstname) {
        validateName(firstname);
        this.firstname = firstname;
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

        this.firstname = nameInput;
    }

    public String getValue(){
        return firstname;
    }

    public void updateFirstName(String newName){
        validateName(newName);
        this.firstname = newName;
    }
}
