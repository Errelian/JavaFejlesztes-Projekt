package com.epam.training.ticketservice.core.movie;


import com.epam.training.ticketservice.core.movie.persistance.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    void saveMovie(MovieDto movieToBeAdded);

    void updateExistingMovie(String title, String genre, Long length);

    void deleteExistingMovie(String title);

    List<Movie> listAllMovies();

    Optional<Movie> getExistingMovieByTitle(String title);

    long getLengthInMinutes(String title);
}
