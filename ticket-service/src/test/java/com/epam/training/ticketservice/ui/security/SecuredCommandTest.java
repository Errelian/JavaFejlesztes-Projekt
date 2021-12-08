package com.epam.training.ticketservice.ui.security;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.access.annotation.Secured;
import org.springframework.shell.Availability;

import static org.junit.jupiter.api.Assertions.*;

class SecuredCommandTest {

    @Test
    void isAdmin() {
        SecuredCommand absClass = Mockito.mock(SecuredCommand.class, Mockito.CALLS_REAL_METHODS);

        assertEquals(Availability.unavailable("You are not signed in").isAvailable(), absClass.isAdmin().isAvailable());

        SecuredCommand.setAuthentication(true);

        assertEquals(Availability.available().isAvailable(), absClass.isAdmin().isAvailable());

    }
}