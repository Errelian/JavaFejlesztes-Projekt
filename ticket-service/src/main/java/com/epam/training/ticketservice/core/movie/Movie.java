package com.epam.training.ticketservice.core.movie;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Generated
public class Movie {
    @Id
    private String title;
    private String genre;
    private Long length;


    public Movie(String title, String genre, Long length) {
        this.title = title;
        this.genre = genre;
        this.length = length;
    }

    @Override
    public String toString() {
        return (title + " (" + genre + ", " + length.toString() + " minutes)");
    }
}
