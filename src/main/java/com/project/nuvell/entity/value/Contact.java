package com.project.nuvell.entity.value;

import com.project.nuvell.infra.exception.InvalidContactException;
import jakarta.persistence.Embeddable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Contact {

    private String contact;

    public Contact() {
    }

    public Contact(String contact) {
        if (validateContact(contact))
            this.contact = formattedContact(contact);
    }

    public boolean validateContact(String contact){
        if (contact == null || contact.isEmpty()){
            throw new InvalidContactException("Cannot be null");
        }

        Pattern p = Pattern.compile("^(\\(?\\d{2}\\)?)?\\s?(\\d{5})\\-?(\\d{4})$");
        Matcher m = p.matcher(contact);

        if (!m.matches()){
            throw new InvalidContactException("Invalid Input " + contact);
        }
        return true;
    }
    public String formattedContact(String contact){
        if (contact.length() != 11){
            throw new InvalidContactException("Contact format Invalid " + contact);
        }
        String ddd = contact.substring(0,2);
        String firstPart = contact.substring(2,7);
        String lastPart = contact.substring(7,11);
        return String.format("(%s) %s-%s", ddd, firstPart, lastPart);
    }

    public String getValue(){
        return contact;
    }

    public void updateContact(String newContact){
        validateContact(newContact);
        this.contact = newContact;
    }
}
