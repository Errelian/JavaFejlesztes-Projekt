package com.epam.training.ticketservice.core.screening;

import com.epam.training.ticketservice.core.movie.Movie;
import com.epam.training.ticketservice.core.room.Room;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScreeningDto {

        private final Movie movie;
        private final Room room;
        private final LocalDateTime screeningDate;

}
