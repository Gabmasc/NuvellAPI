package com.project.nuvell.entity.value;

import com.project.nuvell.infra.exception.NullCampExceptionHandler;
import jakarta.persistence.Embeddable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class FirstName {

    private String value;

    public FirstName() {}

    public FirstName(String firstname) {
        validateName(firstname);
        this.value = firstname;
    }

    public void validateName(String nameInput){
        if (nameInput == null || nameInput.isEmpty()){
            throw new NullCampExceptionHandler("Null field is not allowed");
        }
        Pattern p = Pattern.compile("^.?[a-zA-Z]+.$");
        Matcher m = p.matcher(nameInput);
        if (!m.matches()){
            throw new IllegalArgumentException("Invalid Input");
        }
        this.value = nameInput;
    }

    public String getValue(){
        return value;
    }

    public FirstName withUpdatedValue(String newValue){
        return new FirstName(newValue);
    }
}
