package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.core.movie.impl.MovieServiceImpl;
import com.epam.training.ticketservice.core.movie.persistance.entity.Movie;
import com.epam.training.ticketservice.core.room.impl.RoomServiceImpl;
import com.epam.training.ticketservice.core.screening.impl.ScreeningServiceImpl;
import com.epam.training.ticketservice.core.screening.persistance.entity.Screening;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ScreeningCommandTest {


    static private final MovieServiceImpl movieService = mock(MovieServiceImpl.class);
    static private final RoomServiceImpl roomService = mock(RoomServiceImpl.class);
    static private final ScreeningServiceImpl screeningService = mock(ScreeningServiceImpl.class);

    static private final ScreeningCommand screeningCommand = new ScreeningCommand(movieService, roomService, screeningService);


    @Test
    void createScreening() {

        assertEquals("Fill out the required fields, please."  , screeningCommand.createScreening("asd", "joska", "2021-11-29 17:00"));
    }

    @Test
    void listAllScreenings() {

        assertEquals("There are no screenings" ,screeningCommand.listAllScreenings());

        String screeningDate1 = "2021-11-29 17:00";
        String screeningDate2 = "2021-12-13 14:35";

        LocalDateTime testTime1 = LocalDateTime.parse(screeningDate1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime testTime2 = LocalDateTime.parse(screeningDate2, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));


        Screening screening1 = new Screening("asd", "joska", testTime1);
        Screening screening2 = new Screening("asd", "joska", testTime2);


        Movie movie = new Movie("asd", "asd2", 127L);
        Optional<Movie> optionalMovie= Optional.of(movie);

        List<Screening> screeningList = new ArrayList<>();
        screeningList.add(screening1);
        screeningList.add(screening2);

        Mockito.when(screeningService.listScreenings()).thenReturn(screeningList);
        Mockito.when(movieService.getExistingMovieByTitle("asd")).thenReturn(optionalMovie);

        String expected = "asd (asd2, 127 minutes), screened in room joska, at 2021-11-29 17:00\n" +
            "asd (asd2, 127 minutes), screened in room joska, at 2021-12-13 14:35";

        assertEquals(expected,screeningCommand.listAllScreenings());

    }

    @Test
    void deleteScreening() {

        assertEquals("If the screening existed, it was deleted" ,screeningCommand.deleteScreening("asd", "asd2", "2017-12-22 17:22"));
    }
}