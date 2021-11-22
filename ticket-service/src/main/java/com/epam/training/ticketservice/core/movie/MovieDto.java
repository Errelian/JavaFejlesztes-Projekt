package com.epam.training.ticketservice.core.movie;

import lombok.Data;

@Data
public class MovieDto {

    private final String title;
    private final String genre;
    private final Long length;

    public static class Builder {
        private String title;
        private String genre;
        private Long length;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder withLength(Long length){
            this.length = length;
            return this;
        }

        public MovieDto build() {
            return new MovieDto(title, genre, length);
        }
    }

}
