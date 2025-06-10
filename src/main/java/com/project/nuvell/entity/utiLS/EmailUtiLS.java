package com.project.nuvell.entity.utiLS;

import jakarta.persistence.Embeddable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class EmailUtiLS {

    private String email;

    public EmailUtiLS() {
    }

    public EmailUtiLS(String email) {
        validateEmail(email);
        this.email = email;
    }

    public void validateEmail(String emailInput){
        Pattern p = Pattern.compile("[a-z0-9!#$%&'*+=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
        Matcher m = p.matcher(emailInput);

        if (emailInput.isEmpty()){
            throw new IllegalArgumentException("camp null is not allowed");
        }
        if (!m.matches()){
            throw new IllegalArgumentException("Camp Invalid");
        }

        this.email = emailInput;
    }

    public String getValue(){
        return email;
    }

    public void updateEmail(String newEmail){
        validateEmail(newEmail);
        this.email = newEmail;
    }
}
