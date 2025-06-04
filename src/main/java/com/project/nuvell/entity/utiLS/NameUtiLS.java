package com.project.nuvell.entity.utiLS;

import jakarta.persistence.Embeddable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class NameUtiLS {

    private String name;

    public NameUtiLS() {
    }

    public NameUtiLS(String name) {
        validateName(name);
        this.name = name;
    }

    public void validateName(String nameInput){
        Pattern p = Pattern.compile("([a-zA-Z]{3,})\\s([a-zA-Z]{2,}?)(\\s([a-zA-Z]{4,}))?$");
        Matcher m = p.matcher(nameInput);

        if (nameInput.isEmpty()){
            throw new IllegalArgumentException("O campo Full name não pode ser nulo");
        }
        if (!m.matches()){
            throw new IllegalArgumentException("O campo Name não pode conter números ou  está invalido ou não foi aplicado o Sobrenome");
        }

        this.name = nameInput;
    }

    public String getValue(){
        return name;
    }

    public void updateName(String newName){
        validateName(newName);
        this.name = newName;
    }
}
