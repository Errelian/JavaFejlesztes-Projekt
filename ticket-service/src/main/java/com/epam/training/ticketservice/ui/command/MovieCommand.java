package com.epam.training.ticketservice.ui.command;


import com.epam.training.ticketservice.core.movie.Movie;
import com.epam.training.ticketservice.core.movie.MovieDto;
import com.epam.training.ticketservice.core.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class MovieCommand {

    private final MovieService movieService;


    @Autowired
    public MovieCommand(MovieService movieService){
        this.movieService = movieService;
    }

    @ShellMethod(key= "create movie", value="Add the movie to the Database")
    public String createMovie(String title, String genre, Long length){
        MovieDto movieDto = new MovieDto(title, genre, length);
        movieService.saveMovie(movieDto);
        return "Movie saved.";
    }

    @ShellMethod(key="list movies", value="List all movies in the Database")
    public String listAllMovies(){
        List<Movie> movieList = movieService.listAllMovies();
        String stringToReturn = "";
        if(movieList.isEmpty()){
            stringToReturn = "There are no movies at the moment";
        }
        else{
            for (Movie movie : movieList){
                stringToReturn += movie.toString();
            }
        }
        return stringToReturn;
    }

    @ShellMethod(key = "update movie", value = "Update given movie's properties")
    public String updateMovie(String title, String genre, Long length){
        MovieDto movieDTO = new MovieDto(title, genre, length);
        movieService.saveMovie(movieDTO);
        return "Movie updated.";
    }

    @ShellMethod(key = "delete movie", value= "Deletes movie from database.")
    public String DeleteMovie(String title){
        movieService.deleteExistingMovie(title);
        return "If the movie existed, it was deleted.";
    }


}
