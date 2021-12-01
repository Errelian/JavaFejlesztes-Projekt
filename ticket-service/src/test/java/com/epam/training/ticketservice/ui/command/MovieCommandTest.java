package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.core.movie.persistance.entity.Movie;
import com.epam.training.ticketservice.core.movie.impl.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class MovieCommandTest {

    @Mock
    static private MovieServiceImpl movieService;

    @InjectMocks
    static private MovieCommand movieCommand;

    @Test
    void createMovie() {
        assertEquals("Movie saved.", movieCommand.createMovie("joska", "asd", 123L));
    }

    @Test
    void listAllMovies() {
        assertEquals("There are no movies at the moment", movieCommand.listAllMovies());

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("joska", "asd", 123L));

        Mockito.when(movieService.listAllMovies()).thenReturn(movieList);

        assertEquals("joska (asd, 123 minutes)", movieCommand.listAllMovies());
    }

    @Test
    void updateMovie() {
        movieCommand.createMovie("joska", "asd", 123L);
        assertEquals("Movie updated.", movieCommand.updateMovie("joska", "asd", 124L));
    }

    @Test
    void deleteMovie() {

        movieCommand.createMovie("joska", "asd", 123L);
        assertEquals("If the movie existed, it was deleted.", movieCommand.deleteMovie("joska"));

    }
}