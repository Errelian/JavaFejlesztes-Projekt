package com.epam.training.ticketservice.core.movie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;


class MovieServiceImplTest {


    private final MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

    private final MovieServiceImpl underTest = new MovieServiceImpl(movieRepository);

    @Test
    void saveMovie() {
    }

    @Test
    void updateExistingMovie() {
    }

    @Test
    void deleteExistingMovie() {
    }

    @Test
    void listAllMovies() {
    }

    @Test
    void getExistingMovieByTitle() {
    }

    @Test
    void getLengthInMinutes() {
    }
}