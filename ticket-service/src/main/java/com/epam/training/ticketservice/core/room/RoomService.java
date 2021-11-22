package com.epam.training.ticketservice.core.room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    void addNewRoom(RoomDto roomDto);

    void updateExistingRoom(String name, Long cols, Long rows);

    void deleteExistingRoom(String title);

    List<Room> listAllRooms();

    Optional<Room> getRoomByName(String name);

}
