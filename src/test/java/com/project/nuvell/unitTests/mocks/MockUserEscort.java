package com.project.nuvell.unitTests.mocks;

import com.project.nuvell.entity.UserEscort;

import java.util.ArrayList;
import java.util.List;

public class MockUserEscort {

    public UserEscort mockEntity(){
        return mockEntity(0);
    }

    public List<UserEscort> mockEntityList(){
        List<UserEscort> userEscorts = new ArrayList<UserEscort>();
        for (int i = 0; i < 14; i++){
            userEscorts.add(mockEntity(i));
        }
        return userEscorts;
    }

    public UserEscort mockEntity(Integer numb){
        UserEscort userEscort = new UserEscort();
        userEscort.setId(numb.longValue());
        userEscort.updateFirstName("First name Test" + numb);
        userEscort.updateLastName("Last name Test" + numb);
        userEscort.updateSocialName("Social name Test" + numb);
        userEscort.updateAge(Integer.valueOf("Age Test" + numb));
        userEscort.updateCpf("Cpf Test" + numb);
        userEscort.updateGender("Gender Test" + numb);
        userEscort.updateEmail("Email Test" + numb);
        userEscort.updateContact("Contact Test" + numb);

        return userEscort;

    }
}
