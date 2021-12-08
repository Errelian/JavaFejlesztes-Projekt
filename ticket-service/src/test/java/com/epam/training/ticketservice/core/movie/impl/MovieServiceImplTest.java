package com.epam.training.ticketservice.core.movie.impl;

import com.epam.training.ticketservice.core.movie.persistance.entity.Movie;
import com.epam.training.ticketservice.core.movie.persistance.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceImplTest {
    @Mock
    static private MovieRepository movieRepository;

    @InjectMocks
    static private MovieServiceImpl movieService;

    @Test
    void updateExistingMovie() {
    }

    @Test
    void getLengthInMinutes() {
        String title = "Sátántangó";

        assertEquals(-1L, movieService.getLengthInMinutes(title));
    }
}