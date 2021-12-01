package com.epam.training.ticketservice.core.screening;

import com.epam.training.ticketservice.core.movie.persistance.entity.Movie;
import com.epam.training.ticketservice.core.room.persistance.entity.Room;
import lombok.Data;
import lombok.Generated;

import java.time.LocalDateTime;

@Data
@Generated
public class ScreeningDto {

    private final Movie movie;
    private final Room room;
    private final LocalDateTime screeningDate;

}
