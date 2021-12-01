package com.epam.training.ticketservice.core.movie.persistance.repository;

import com.epam.training.ticketservice.core.movie.persistance.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Modifying
    @Transactional
    List<Movie> deleteByTitle(String title);

    Optional<Movie> findByTitle(String title);

}
