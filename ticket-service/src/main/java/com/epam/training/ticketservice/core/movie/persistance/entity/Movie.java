package com.epam.training.ticketservice.core.movie.persistance.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.Id;

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
