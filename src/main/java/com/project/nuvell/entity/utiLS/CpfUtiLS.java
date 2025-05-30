package com.project.nuvell.entity.utiLS;

import jakarta.persistence.Embeddable;

@Embeddable
public class CpfUtiLS {

    private String cpf;

    public CpfUtiLS(String cpf) {
        validateCpf(cpf);
        this.cpf = formatCpf(cpf);
    }

    public CpfUtiLS() {
    }

    public static boolean validateCpf(String value){
        value = value.replaceAll("[^0-9]", "");

        if (value.length() != 11 || value.matches("(\\d)\\1{10}")){
            throw new IllegalArgumentException("Invalid CPF");
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11 ; i++){
            digits[i] = value.charAt(i) - '0';
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

    public static String formatCpf(String value){
        value = value.replaceAll("[^0-9]", "");
        return value.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public String getValue() {
        validateCpf(cpf);
        return cpf;
    }

    public void updateValue(String newCpf) {
        if (newCpf.isEmpty()){
            throw  new IllegalArgumentException("Not be empty");
        }
        validateCpf(newCpf);
        this.cpf = newCpf;
    }
}
