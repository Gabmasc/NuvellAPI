package com.project.nuvell.service;

import com.project.nuvell.entity.UserEscort;

import java.util.List;

public interface UserEscortService {

    List<UserEscort> findAll();

    UserEscort findById(Long id);

    UserEscort create(UserEscort userEscort);
    UserEscort update(UserEscort userToUpdate);

    void delete(Long id);


}
