package com.project.nuvell.service.impl;

import com.project.nuvell.entity.UserEscort;
import com.project.nuvell.entity.utiLS.CpfUtiLS;
import com.project.nuvell.entity.utiLS.GenderUtils;
import com.project.nuvell.repository.UserEscortRepository;
import com.project.nuvell.service.UserEscortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserEscortServiceImpl implements UserEscortService {

    private Logger logger = LoggerFactory.getLogger(UserEscortServiceImpl.class.getName());

    private final UserEscortRepository userEscortRepository;
    private UserEscort userToUpdate;

    public UserEscortServiceImpl(UserEscortRepository userEscortRepository) {
        this.userEscortRepository = userEscortRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserEscort> findAll() {
        logger.info("Finding a User Escort");

        return this.userEscortRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public UserEscort findById(Long id) {
        logger.info("Finding ALL Users Escorts");

        return this.userEscortRepository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public UserEscort create(UserEscort userEscort) {
        logger.info("Creating a User Escort");


        return this.userEscortRepository.save(userEscort);
    }


    @Override
     public UserEscort update(UserEscort userToUpdate) {
        logger.info("Updating a User Escort");


        UserEscort userInDatabase = userEscortRepository.findById(userToUpdate.getId()).orElseThrow();


        // userInDatabase.setFullName(userToUpdate.getFullName());
        userInDatabase.updateCpf(userToUpdate.getCpf());
        // userInDatabase.updateGender(new GenderUtils());

        return userEscortRepository.save(userInDatabase);
    }


    @Transactional
    @Override
    public void delete(Long id) {
        logger.info("Deleting a User Escort");

        UserEscort userInDB = this.findById(id);
        this.userEscortRepository.delete(userInDB);
    }
}
