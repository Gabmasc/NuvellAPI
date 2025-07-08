package com.project.nuvell.service.impl;

import com.project.nuvell.entity.UserEscort;
import com.project.nuvell.repository.UserEscortRepository;
import com.project.nuvell.unitTests.mocks.MockUserEscort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class UserEscortServiceImplTest {


    MockUserEscort input;
    @InjectMocks
    private UserEscortServiceImpl service;
    @Mock
    UserEscortRepository repository;

    @BeforeEach
    void setUp() {
        input = new MockUserEscort();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() {

        UserEscort user = input.mockEntity(1);
        user.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(user));

        var result = service.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getFirstName());
        assertNotNull(result.getLastName());
        assertNotNull(result.getSocialName());
        assertNotNull(result.getAge());
        assertNotNull(result.getCpf());
        assertNotNull(result.getContact());

        assertEquals("First name test", result.getFirstName());
        assertEquals("last name test", result.getLastName());
        assertEquals("Social name test", result.getSocialName());
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }
}
