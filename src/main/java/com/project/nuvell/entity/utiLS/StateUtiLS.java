package com.project.nuvell.entity.utiLS;

import jakarta.persistence.Embeddable;

import java.util.Arrays;
import java.util.List;

@Embeddable
public class StateUtiLS {

    private static final List<String> StateOfBrazil = Arrays.asList("Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Espirito Santo", "Goiás", "Distrito Federal",
            "Maranhão","Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraiba", "Paraiba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio grande do norte",
            "Rio grande do SUl", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins");

    private String value;

    public StateUtiLS() {
    }

    public StateUtiLS(String value) {
        validateValue(value);
        this.value = value;
    }

    public void validateValue(String value){
        if (value.isEmpty() || StateOfBrazil.stream().noneMatch(v -> v.matches(value)))
            throw new IllegalArgumentException("Estado Invalido");

        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public void updateValue(String newValue){
        if (newValue.isEmpty())
            throw new IllegalArgumentException("Can not be null");

        this.value = newValue;
    }
}
