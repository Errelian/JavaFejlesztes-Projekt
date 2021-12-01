package com.epam.training.ticketservice.core.screening;

import com.epam.training.ticketservice.core.screening.persistance.entity.Screening;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ScreeningService {

    void addScreening(ScreeningDto screeningDto);

    void deleteScreening(String movieTitle, String roomName, LocalDateTime screeeningDate);

    List<Screening> listScreenings();

    Long getScreeningId(String title, String roomName, LocalDateTime screeningDate);

    String getNameById(Long id);

    Screening getScreeningById(Long id);

    Optional<Screening> getScreeningByTitleRoomAndDate(String movieTitle, String roomName, LocalDateTime screeningDate);

    List<Screening> getScreeningsInSameRoom(String roomName);
}
