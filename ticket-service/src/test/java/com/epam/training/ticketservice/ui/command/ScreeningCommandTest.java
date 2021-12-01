package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.core.movie.persistance.entity.Movie;
import com.epam.training.ticketservice.core.movie.impl.MovieServiceImpl;
import com.epam.training.ticketservice.core.room.impl.RoomServiceImpl;
import com.epam.training.ticketservice.core.screening.persistance.entity.Screening;
import com.epam.training.ticketservice.core.screening.impl.ScreeningServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ScreeningCommandTest {

    @Mock
    static private MovieServiceImpl movieService;

    @Mock
    static private RoomServiceImpl roomService;

    @Mock
    static private ScreeningServiceImpl screeningService;

    @InjectMocks
    static private ScreeningCommand screeningCommand;


    @Test
    void createScreening() {

        assertEquals("Fill out the required fields, please."  , screeningCommand.createScreening("asd", "joska", "2021-11-29 17:00"));
    }

    @Test
    void listAllScreenings() {

        assertEquals("There are no screenings" ,screeningCommand.listAllScreenings());

        String screeningDate = "2021-11-29 17:00";

        LocalDateTime testTime = LocalDateTime.parse(screeningDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        Screening screening = new Screening("asd", "joska", testTime);
        Movie movie = new Movie("asd", "asd2", 127L);
        Optional<Movie> optionalMovie= Optional.of(movie);

        List<Screening> screeningList = new ArrayList<>();
        screeningList.add(screening);

        //Mockito.when(screeningService.listScreenings()).thenReturn(screeningList);
        //Mockito.when(movieService.getExistingMovieByTitle("asd")).thenReturn(optionalMovie);


        System.out.println(screeningCommand.listAllScreenings());
        //assertEquals("asd (asd2, 127 minutes), screened in room joska, at 2021-11-29 17:00" ,screeningCommand.listAllScreenings());

    }

    @Test
    void deleteScreening() {

        assertEquals("If the screening existed, it was deleted" ,screeningCommand.deleteScreening("asd", "asd2", "2017-12-22 17:22"));
    }
}