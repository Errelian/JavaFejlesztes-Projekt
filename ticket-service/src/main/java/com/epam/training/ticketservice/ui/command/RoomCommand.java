package com.epam.training.ticketservice.ui.command;


import com.epam.training.ticketservice.core.movie.Movie;
import com.epam.training.ticketservice.core.room.Room;
import com.epam.training.ticketservice.core.room.RoomDto;
import com.epam.training.ticketservice.core.room.RoomService;
import org.dom4j.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class RoomCommand {

    private final RoomService roomService;


    @Autowired
    public RoomCommand(RoomService roomService){
        this.roomService = roomService;
    }

    @ShellMethod(key = "create room", value = "Creates new room in the Database")
    public String createNewRoom(String name, Long rows, Long columns){
        RoomDto roomDto = new RoomDto(name, rows, columns);
        roomService.addNewRoom(roomDto);
        return "Room saved.";
    }

    @ShellMethod(key= "update room", value= "Updates an existing room in the Database")
    public String updateRoom(String name, Long rows, Long columns){
        RoomDto roomDto = new RoomDto(name, rows, columns);
        roomService.updateExistingRoom(roomDto);
        return "Room updated.";
    }

    @ShellMethod(key= "delete room", value = "Deletes room from Database")
    public String deleteRoom(String name){
        roomService.deleteExistingRoom(name);
        return "Room probably deleted.";
    }

    @ShellMethod(key="list rooms", value = "List all rooms.")
    public String listAllRooms(){
        List<Room> roomList = roomService.listAllRooms();
        String stringToReturn = "";
        if(roomList.isEmpty()){
            stringToReturn = "There are no room at the moment\n\nc";
        }
        else{
            for (Room room : roomList){
                stringToReturn += room.toString() + "\n";
            }
        }
        return stringToReturn.substring(0,stringToReturn.length()-1);
    }
}