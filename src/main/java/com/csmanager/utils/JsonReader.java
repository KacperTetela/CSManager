package com.csmanager.utils;

import com.csmanager.model.player.player.Player;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonReader {
    public static List<Player> read(String pathName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Player[] players = objectMapper.readValue(new File(pathName), Player[].class);
            return Arrays.stream(players).toList();
        } catch (IOException e) {
            System.out.println("Json file not found");
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
