package com.epam.training.ticketservice.core.screening;

import com.epam.training.ticketservice.core.movie.MovieDto;
import com.epam.training.ticketservice.core.room.RoomDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ScreeningDto {

        private final MovieDto movie;
        private final RoomDto room;
        private final LocalDateTime screeningDate;

}
