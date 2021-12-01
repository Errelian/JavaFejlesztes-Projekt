package com.epam.training.ticketservice.core.movie.impl;

import com.epam.training.ticketservice.core.movie.persistance.entity.Movie;
import com.epam.training.ticketservice.core.movie.MovieDto;
import com.epam.training.ticketservice.core.movie.persistance.repository.MovieRepository;
import com.epam.training.ticketservice.core.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MovieServiceImpl implements MovieService {


    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public void saveMovie(MovieDto movieToBeAdded) {

        Movie newMovie = new Movie(movieToBeAdded.getTitle(), movieToBeAdded.getGenre(), movieToBeAdded.getLength());
        movieRepository.save(newMovie);

    }

    @Override
    public void updateExistingMovie(String title, String genre, Long length) {
        Optional<Movie> queriedMovie = movieRepository.findByTitle(title);

        if (queriedMovie.isPresent()) {
            Movie newMovie = queriedMovie.get();
            newMovie.setGenre(genre);
            newMovie.setLength(length);
            movieRepository.save(newMovie);
        }
    }

    @Override
    public void deleteExistingMovie(String title) {
        movieRepository.deleteByTitle(title);
    }

    @Override
    public List<Movie> listAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getExistingMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public long getLengthInMinutes(String title) {
        Optional<Movie> movieTemp = movieRepository.findByTitle(title);

        if (movieTemp.isPresent()) {
            Movie movie = movieTemp.get();
            return movie.getLength();
        }
        return -1L;
    }
}
