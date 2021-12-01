package com.epam.training.ticketservice.core.room;

import com.epam.training.ticketservice.core.room.persistance.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    void addNewRoom(RoomDto roomDto);

    void updateExistingRoom(RoomDto roomDto);

    void deleteExistingRoom(String name);

    List<Room> listAllRooms();

    Optional<Room> getRoomByName(String name);

}
