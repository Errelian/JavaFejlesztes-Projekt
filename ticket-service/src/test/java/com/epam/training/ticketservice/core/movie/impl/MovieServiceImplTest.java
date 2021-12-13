package com.epam.training.ticketservice.core.movie.impl;

import com.epam.training.ticketservice.core.movie.persistance.entity.Movie;
import com.epam.training.ticketservice.core.movie.persistance.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceImplTest {
    private final MovieRepository movieRepository = mock(MovieRepository.class);

    private final MovieServiceImpl movieService = new MovieServiceImpl(movieRepository);

    @Test
    void getLengthInMinutes() {
        String title = "Sátántangó";

        assertEquals(-1L, movieService.getLengthInMinutes(title));

        Optional<Movie> movieOptional = Optional.of(new Movie(title, "comedy", 50L));

        when(movieRepository.findByTitle(title)).thenReturn(movieOptional);

        assertEquals(50L, movieService.getLengthInMinutes(title));
    }
}