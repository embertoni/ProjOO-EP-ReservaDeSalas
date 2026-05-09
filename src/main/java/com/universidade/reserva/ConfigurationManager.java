package com.universidade.reserva;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private List<String> availableRooms;

    private ConfigurationManager() {
        availableRooms = new ArrayList<>();
        availableRooms.add("Sala Individual 01");
        availableRooms.add("Sala de Grupo 02");
        availableRooms.add("Laboratório 03");
    }

    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public List<String> getAvailableRooms() {
        return availableRooms;
    }

    public void addRoom(String roomName) {
        if  (!availableRooms.contains(roomName)) {
            availableRooms.add(roomName);
        }
    }

    public void removeRoom(String roomName) {
        if (availableRooms.contains(roomName)) {
            availableRooms.remove(roomName);
        }
    }
}