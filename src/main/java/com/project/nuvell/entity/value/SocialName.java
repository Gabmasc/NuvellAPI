package com.project.nuvell.entity.value;

import com.project.nuvell.infra.exception.NullCampExceptionHandler;
import jakarta.persistence.Embeddable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class SocialName {

    private String socialname;

    public SocialName() {
    }

    public SocialName(String socialname) {
        validateName(socialname);
        this.socialname = socialname;
    }

    public void validateName(String nameInput){
        if (nameInput == null || nameInput.isEmpty()){
            throw new NullCampExceptionHandler("Null camp is not allowed");
        }
        Pattern p = Pattern.compile("^.?[a-zA-Z]+.$");
        Matcher m = p.matcher(nameInput);
        if (!m.matches()){
            throw new IllegalArgumentException("Input Invalid");
        }
        this.socialname = nameInput;
    }

    public String getValue(){
        return socialname;
    }

    public void updateSocialName(String newName){
        validateName(newName);
        this.socialname = newName;
    }
}
