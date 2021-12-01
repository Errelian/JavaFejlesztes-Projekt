package com.epam.training.ticketservice.core.screening.impl;


import com.epam.training.ticketservice.core.screening.persistance.entity.Screening;
import com.epam.training.ticketservice.core.screening.ScreeningDto;
import com.epam.training.ticketservice.core.screening.persistance.repository.ScreeningRepository;
import com.epam.training.ticketservice.core.screening.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    private final ScreeningRepository screeningRepository;


    @Autowired
    public ScreeningServiceImpl(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }


    @Override
    public void addScreening(ScreeningDto screeningDto) {

        Screening screening = new Screening(screeningDto.getMovie().getTitle(), screeningDto.getRoom().getName(),
            screeningDto.getScreeningDate());

        screeningRepository.save(screening);

    }

    @Override
    public void deleteScreening(String movieTitle, String roomName, LocalDateTime screeeningDate) {
        screeningRepository.deleteByMovieTitleAndRoomNameAndScreeningDate(movieTitle, roomName, screeeningDate);
    }

    @Override
    public List<Screening> listScreenings() {
        return screeningRepository.findAll();
    }

    @Override
    public Long getScreeningId(String title, String roomName, LocalDateTime screeningDate) {
        Optional<Screening> wantedScreening =
            screeningRepository.findByMovieTitleAndRoomNameAndScreeningDate(title, roomName, screeningDate);

        if (wantedScreening.isPresent()) {
            return wantedScreening.get().getId();
        }
        return -1L;
    }

    @Override
    public String getNameById(Long id) {
        Screening wantedScreening = screeningRepository.getById(id);
        return wantedScreening.getRoomName();
    }

    @Override
    public Screening getScreeningById(Long id) {
        return screeningRepository.getById(id);
    }

    @Override
    public Optional<Screening> getScreeningByTitleRoomAndDate(String movieTitle, String roomName,
                                                              LocalDateTime screeningDate) {
        return screeningRepository.findByMovieTitleAndRoomNameAndScreeningDate(movieTitle, roomName, screeningDate);
    }

    @Override
    public List<Screening> getScreeningsInSameRoom(String roomName) {
        return screeningRepository.findByRoomName(roomName);
    }
}
