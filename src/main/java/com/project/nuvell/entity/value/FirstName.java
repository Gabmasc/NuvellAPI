package com.project.nuvell.entity.value;

import com.project.nuvell.infra.exception.NullCampExceptionHandler;
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
        if (nameInput == null || nameInput.isEmpty()){
            throw new NullCampExceptionHandler("Null camp is not allowed");
        }
        Pattern p = Pattern.compile("^.?[a-zA-Z]+.$");
        Matcher m = p.matcher(nameInput);
        if (!m.matches()){
            throw new IllegalArgumentException("Invalid Input");
        }
        this.firstname = nameInput;
    }

    public String getValue(){
        validateName(firstname);
        return firstname;
    }

    public void updateFirstName(String newName){
        validateName(newName);
        this.firstname = newName;
    }
}
