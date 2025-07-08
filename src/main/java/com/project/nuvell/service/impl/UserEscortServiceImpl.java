package com.project.nuvell.service.impl;

import com.project.nuvell.entity.Address;
import com.project.nuvell.entity.UserEscort;
import com.project.nuvell.repository.AddressRepository;
import com.project.nuvell.repository.UserEscortRepository;
import com.project.nuvell.service.UserEscortService;
import com.project.nuvell.service.ViaCepService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserEscortServiceImpl implements UserEscortService {

    private Logger logger = LoggerFactory.getLogger(UserEscortServiceImpl.class.getName());

    private final UserEscortRepository userEscortRepository;
    private final AddressRepository addressRepository;

    private ViaCepService viaCepService;

    public UserEscortServiceImpl(UserEscortRepository userEscortRepository, AddressRepository addressRepository, ViaCepService viaCepService) {
        this.userEscortRepository = userEscortRepository;
        this.addressRepository = addressRepository;
        this.viaCepService = viaCepService;
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
        String cep = userEscort.getAddress().getCep();
        Address address = addressRepository.findById(Long.valueOf(cep)).orElseGet(() -> {
            Address newAddress = viaCepService.queryCep(cep);
            addressRepository.save(newAddress);
            return newAddress;});
        userEscort.setAddress(address);
        return this.userEscortRepository.save(userEscort);
    }


    @Transactional
    @Override
     public UserEscort update(UserEscort userToUpdate) {
        logger.info("Updating a User Escort");

        UserEscort userInDatabase = userEscortRepository.findById(userToUpdate.getId()).orElseThrow();

        userInDatabase.updateFirstName(userToUpdate.getFirstName());
        userInDatabase.updateLastName(userToUpdate.getLastName());
        userInDatabase.updateSocialName(userToUpdate.getSocialName());
        userInDatabase.updateCpf(userToUpdate.getCpf());
        userInDatabase.updateAge(userToUpdate.getAge());
        userInDatabase.updateContact(userToUpdate.getContact());
        userInDatabase.updateEmail(userToUpdate.getEmail());
        userInDatabase.updateGender(userToUpdate.getGender());
        userInDatabase.setAddress(userToUpdate.getAddress());

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
