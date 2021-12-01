package com.epam.training.ticketservice.core.room.impl;

import com.epam.training.ticketservice.core.room.persistance.entity.Room;
import com.epam.training.ticketservice.core.room.RoomDto;
import com.epam.training.ticketservice.core.room.persistance.repository.RoomRepository;
import com.epam.training.ticketservice.core.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {


    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void addNewRoom(RoomDto roomDto) {
        Room newRoom = new Room(roomDto.getName(), roomDto.getSeatRows(), roomDto.getSeatColumns());
        roomRepository.save(newRoom);
    }

    @Override
    public void updateExistingRoom(RoomDto roomDto) {
        Optional<Room> queriedRoom = roomRepository.findByName(roomDto.getName());

        if (queriedRoom.isPresent()) {
            Room newRoom = queriedRoom.get();
            newRoom.setSeatColumns(roomDto.getSeatColumns());
            newRoom.setSeatRows(roomDto.getSeatRows());
            roomRepository.save(newRoom);
        }
        ;
    }

    @Override
    public void deleteExistingRoom(String name) {
        roomRepository.deleteByName(name);
    }

    @Override
    public List<Room> listAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> getRoomByName(String name) {
        return roomRepository.findByName(name);
    }
}
