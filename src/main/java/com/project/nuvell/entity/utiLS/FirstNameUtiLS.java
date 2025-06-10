package com.project.nuvell.entity.utiLS;

import jakarta.persistence.Embeddable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class FirstNameUtiLS {

    private String firtsname;

    public FirstNameUtiLS() {
    }

    public FirstNameUtiLS(String firtsname) {
        validateName(firtsname);
        this.firtsname = firtsname;
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

        this.firtsname = nameInput;
    }

    public String getValue(){
        return firtsname;
    }

    public void updateFirstName(String newName){
        validateName(newName);
        this.firtsname = newName;
    }
}
