package com.project.nuvell.entity;

import com.project.nuvell.infra.exception.NullCampExceptionHandler;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Address implements Serializable {

    @Id
    private String cep;
    private String uf;
    private String localidade;

    public Address() {
    }

    public Address(String cep, String localidade, String uf) {
        validateCep(cep);
        this.cep = cep;
        this.localidade = localidade;
        this.uf = uf;
    }

    public void validateCep(String cepToValidate){
        if (cepToValidate == null || cepToValidate.isEmpty() || cepToValidate.isBlank()){
            throw new NullCampExceptionHandler("O campo de cep não pode ser nulo");
        }

        cepToValidate.replaceAll("-", "");
        if (cepToValidate.length() != 8){
            throw new IllegalArgumentException("O cep é inválido");
        }
        this.cep = cepToValidate.substring(0,5) + "-" + cepToValidate.substring(5);
    }

    public String getCep() {return cep;}

    public void updateCep(String newCep){
        validateCep(newCep);
        this.cep = newCep;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
