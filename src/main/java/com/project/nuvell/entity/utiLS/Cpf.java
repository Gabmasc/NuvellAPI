package com.project.nuvell.entity.utiLS;

import jakarta.persistence.Embeddable;
@Embeddable
public class Cpf {

    private String cpf;

    public Cpf(String value) {
        validate(value);
        this.cpf = formatCpf(value);
    }

    public Cpf() {
    }

    public void validate(String cpfValue){
        if (cpfValue == null || cpfValue.isEmpty()){
            throw new IllegalArgumentException("Cpf cannot be empty");
        }

        if (!validateCpf(cpfValue)){
            throw new IllegalArgumentException("Invalid Cpf");
        }
    }

    public boolean validateCpf(String value){

        String cpf = normalizeCpf(value);
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")){
            throw new IllegalArgumentException("Invalid CPF");
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11 ; i++){
            digits[i] = cpf.charAt(i) - '0';
        }

        int sum = 0;
        for (int i = 0; i< 9; i++){
            sum+= digits[i] * (10 - i);
        }
        int remainder = sum % 11;
        int digit1 = (remainder < 2) ? 0 : (11 - remainder);

        sum = 0;
        for (int i = 0; i < 10; i++){
            sum+= digits[i] * (11 - i);
        }
        remainder = sum % 11;
        int digit2 = (remainder < 2) ? 0 : (11 - remainder);

        return (digit1 == digits[9] && digit2 == digits[10]);
    }

    public String formatCpf(String value){
        String raw = normalizeCpf(value);
        return raw.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public String normalizeCpf(String value){
        return value.replaceAll("[^0-9]", "");
    }

    public String getValue() {
        return cpf;
    }

    public void updateValue(String newCpf) {
        validate(newCpf);
        this.cpf = newCpf;
    }
}
