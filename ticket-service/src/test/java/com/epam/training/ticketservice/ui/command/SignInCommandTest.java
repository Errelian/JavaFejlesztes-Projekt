package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.core.movie.MovieServiceImpl;
import com.epam.training.ticketservice.core.room.RoomServiceImpl;
import com.epam.training.ticketservice.core.screening.ScreeningServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class SignInCommandTest {


    SignInCommand signInCommand = new SignInCommand();

    @Test
    void signInAdmin() {
        assertEquals("Signed in.", signInCommand.signInAdmin("admin", "admin"));
        assertEquals("Login failed due to incorrect credentials.", signInCommand.signInAdmin("asd", "asd"));
        assertEquals("Login failed due to incorrect credentials.", signInCommand.signInAdmin("admin", "asd"));

    }

    @Test
    void signOut() {
        assertEquals("Signed out, mate.", signInCommand.signOut());
    }

    @Test
    void describeAccount() {
        assertEquals("You are not signed in.", signInCommand.describeAccount());
        signInCommand.signInAdmin("admin", "admin");
        assertEquals("Signed in with privileged account admin", signInCommand.describeAccount());


    }
}