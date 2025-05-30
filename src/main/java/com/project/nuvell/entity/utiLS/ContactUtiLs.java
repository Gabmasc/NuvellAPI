package com.project.nuvell.entity.utiLS;

import jakarta.persistence.Embeddable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class ContactUtiLs {

    private String contact;

    public ContactUtiLs() {
    }

    public ContactUtiLs(String contact) {
        if (validateContact(contact))
            this.contact = formattedContact(contact);
    }

    public boolean validateContact(String contact){

        Pattern p = Pattern.compile("^(\\(?\\d{2}\\)?)?\\s?(\\d{5})\\-?(\\d{4})$");
        Matcher m = p.matcher(contact);

        if (!m.matches()){
            throw new IllegalArgumentException("Invalid Input");
        }
        return true;
    }
    public String formattedContact(String contact){
        if (contact.length() != 11){
            throw new IllegalStateException("Contact format Invalid");
        }
        String ddd = contact.substring(0,2);
        String firstPart = contact.substring(2,7);
        String lastPart = contact.substring(7,11);
        return String.format("(%s) %s-%s", ddd, firstPart, lastPart);
    }

    public String getValue(){
        return contact;
    }
}
