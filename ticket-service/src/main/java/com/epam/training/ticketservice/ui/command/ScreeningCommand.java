package com.epam.training.ticketservice.ui.command;


import com.epam.training.ticketservice.core.movie.persistance.entity.Movie;
import com.epam.training.ticketservice.core.movie.MovieService;
import com.epam.training.ticketservice.core.room.persistance.entity.Room;
import com.epam.training.ticketservice.core.room.RoomService;
import com.epam.training.ticketservice.core.screening.persistance.entity.Screening;
import com.epam.training.ticketservice.core.screening.ScreeningDto;
import com.epam.training.ticketservice.core.screening.ScreeningService;
import com.epam.training.ticketservice.ui.security.SecuredCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@ShellComponent
public class ScreeningCommand extends SecuredCommand {

    private final MovieService movieService;
    private final RoomService roomService;
    private final ScreeningService screeningService;


    @Autowired
    public ScreeningCommand(MovieService movieService, RoomService roomService, ScreeningService screeningService) {
        this.movieService = movieService;
        this.roomService = roomService;
        this.screeningService = screeningService;
    }


    @ShellMethodAvailability("isAdmin")
    @ShellMethod(key = "create screening", value = "Creates another screening.")
    public String createScreening(String movieTitle, String roomName, String screeningDate) {
        Optional<Movie> movie = movieService.getExistingMovieByTitle(movieTitle);
        Optional<Room> room = roomService.getRoomByName(roomName);

        if (room.isPresent() && movie.isPresent()) {
            LocalDateTime screeningTime =
                LocalDateTime.parse(screeningDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            List<Screening> screeningsInTheSameRoom = screeningService.getScreeningsInSameRoom(room.get().getName());

            for (Screening screening : screeningsInTheSameRoom) {

                if (screeningTime.isAfter(screening.getScreeningDate()) && screeningTime.isBefore(
                    screening.getScreeningDate()
                        .plusMinutes(movieService.getLengthInMinutes(screening.getMovieTitle())))) {
                    return "There is an overlapping screening";
                }

                if (screeningTime.isAfter(screening.getScreeningDate()
                    .plusMinutes(movieService.getLengthInMinutes(screening.getMovieTitle()))) && screeningTime.isBefore(
                    screening.getScreeningDate()
                        .plusMinutes(movieService.getLengthInMinutes(screening.getMovieTitle()) + 10))) {
                    return "This would start in the break period after another screening in this room";
                }
            }

            ScreeningDto screeningDto = new ScreeningDto(movie.get(), room.get(), screeningTime);
            screeningService.addScreening(screeningDto);
            return "Screening saved.";
        }
        return "Fill out the required fields, please.";
    }

    @ShellMethod(key = "list screenings", value = "Lists all screenings.")
    public String listAllScreenings() {
        List<Screening> screenings = screeningService.listScreenings();
        String stringToReturn = "";
        if (screenings.isEmpty()) {
            return "There are no screenings";
        } else {
            for (Screening screening : screenings) {
                Optional<Movie> movie = movieService.getExistingMovieByTitle(screening.getMovieTitle());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

                String formattedDateTime = screening.getScreeningDate().format(formatter);
                stringToReturn +=
                    screening.getMovieTitle() + " (" + movie.get().getGenre() + ", " + movie.get().getLength()
                        + " minutes), screened in room " + screening.getRoomName() + ", at " + formattedDateTime + "\n";
            }
        }
        return stringToReturn.substring(0, stringToReturn.length() - 1);

    }

    @ShellMethodAvailability("isAdmin")
    @ShellMethod(key = "delete screening", value = "Deletes a screening.")
    public String deleteScreening(String movieTitle, String roomName, String screeningDate) {
        LocalDateTime screeningTime =
            LocalDateTime.parse(screeningDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        screeningService.deleteScreening(movieTitle, roomName, screeningTime);

        return "If the screening existed, it was deleted";
    }
}
