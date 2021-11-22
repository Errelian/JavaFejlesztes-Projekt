package com.epam.training.ticketservice.core.room;


import com.epam.training.ticketservice.core.movie.MovieDto;
import lombok.Data;

@Data
public class RoomDto {

    private final String name;
    private final Long seatRows;
    private final Long seatColumns;


    public static class Builder {
        private String name;
        private Long seatRows;
        private Long seatColumns;

        public RoomDto.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public RoomDto.Builder withSeatRows(Long seatRows) {
            this.seatRows = seatRows;
            return this;
        }

        public RoomDto.Builder withLength(Long seatColumns){
            this.seatColumns = seatColumns;
            return this;
        }

        public RoomDto build() {
            return new RoomDto(name, seatRows, seatColumns);
        }
    }
}
