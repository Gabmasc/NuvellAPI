package com.project.nuvell.entity.value;

import com.project.nuvell.infra.exception.InvalidEmailException;
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
        if (emailInput == null || emailInput.isEmpty() || !EMAIL_PATTERN_REGEX.matcher(emailInput).matches()){
            throw new InvalidEmailException("Email Invalid " + emailInput);
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
