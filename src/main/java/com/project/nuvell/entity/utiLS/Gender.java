package com.project.nuvell.entity.utiLS;

import jakarta.persistence.Embeddable;
@Embeddable
public class Gender {

    private String gender;

    public Gender() {
    }

    public Gender(String gender) {
        validateGender(gender);
        this.gender = gender;
    }

    public void validateGender(String gender){
        String gender1 = "homem";
        String gender2 = "mulher";
        String gender3 = "trans";

        validateGenderIfIsEmpty(gender);

        if (!gender.equals(gender1) && !gender.equals(gender2) && !gender.equals(gender3)){
            throw new IllegalArgumentException("Value not accepted.");
        }

        this.gender = gender;

    }
    public void validateGenderIfIsEmpty(String gender){

        if (gender.isEmpty()){
            throw new IllegalArgumentException("Gender empty is not allowed");
        }
    }

    public String getValue(){
        return gender;
    }

    public void updateGender(String newGender){
         validateGender(newGender);
         this.gender = newGender;
    }
}
