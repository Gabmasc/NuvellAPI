package com.project.nuvell.service.impl;

import com.project.nuvell.entity.UserEscort;
import com.project.nuvell.repository.UserEscortRepository;
import com.project.nuvell.service.UserEscortService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserEscortServiceImpl implements UserEscortService {

    private final UserEscortRepository userEscortRepository;

    public UserEscortServiceImpl(UserEscortRepository userEscortRepository) {
        this.userEscortRepository = userEscortRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserEscort> findAll() {
        return this.userEscortRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public UserEscort findById(Long id) {
        return this.userEscortRepository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public UserEscort create(UserEscort userEscort) {
        return this.userEscortRepository.save(userEscort);
    }

    @Transactional
    @Override
    public UserEscort update(Long id, UserEscort userToUpdate) {
        UserEscort userInDatabase = this.findById(id);
        if (!userInDatabase.getId().equals(userToUpdate.getId())){
            throw new IllegalArgumentException("Update IDs must be the same");
        }

        userInDatabase.setFullName(userToUpdate.getFullName());
        userInDatabase.setCpf(userToUpdate.getCpf());
        userInDatabase.setAge(userToUpdate.getAge());
        userInDatabase.setEmail(userToUpdate.getEmail());
        userInDatabase.setContact(userToUpdate.getContact());
        userInDatabase.setState(userToUpdate.getState());
        userInDatabase.setGender(userToUpdate.getGender());

        return this.userEscortRepository.save(userInDatabase);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        UserEscort userInDB = this.findById(id);
        this.userEscortRepository.delete(userInDB);
    }
}
