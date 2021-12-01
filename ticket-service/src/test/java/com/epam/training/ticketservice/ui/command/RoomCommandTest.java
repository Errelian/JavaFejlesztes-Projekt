package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.core.room.persistance.entity.Room;
import com.epam.training.ticketservice.core.room.impl.RoomServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoomCommandTest {
    @Mock
    static private RoomServiceImpl roomService;

    @InjectMocks
    static private RoomCommand roomCommand;

    @Test
    void createNewRoom() {
        assertEquals("Room saved.", roomCommand.createNewRoom("testroom", 69L, 420L));
    }

    @Test
    void updateRoom() {
        assertEquals("Room updated.", roomCommand.updateRoom("room", 1L, 1L));
    }

    @Test
    void deleteRoom() {
        assertEquals("Room probably deleted.", roomCommand.deleteRoom("name"));
    }

    @Test
    void listAllRooms() {
        assertEquals("There are no rooms at the moment", roomCommand.listAllRooms());

        List<Room> roomList = new ArrayList<>();
        roomList.add(new Room("name", 1L, 1L));

        when(roomService.listAllRooms()).thenReturn(roomList);
        System.out.println(roomCommand.listAllRooms());

        assertEquals("Room name with 1 seats, 1 rows and 1 columns", roomCommand.listAllRooms());

    }
}