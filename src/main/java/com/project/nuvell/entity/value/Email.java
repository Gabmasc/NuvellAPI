package com.project.nuvell.entity.value;

import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

@Embeddable
public class Email {

    private String email;

    private static final Pattern EMAIL_PATTERN_REGEX =
            Pattern.compile("[a-z0-9!#$%&'*+=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");

    public Email() {
    }

    public Email(String email) {
        validateEmail(email);
        this.email = email;
    }

    public void validateEmail(String emailInput){

        if (emailInput.isEmpty()){
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (!EMAIL_PATTERN_REGEX.matcher(emailInput).matches()){
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
