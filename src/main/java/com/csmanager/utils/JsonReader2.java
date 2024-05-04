package com.csmanager.utils;

import com.csmanager.model.player.builder.Player;
import com.csmanager.model.player.builder.RoleStats;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonReader2 {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("test.json"),new Player("test"));


        List<Player> players = read();
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public static List<Player> read()  {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
           Player[] players = objectMapper.readValue(new File("ProPlayers2.json"), Player[].class);
            return Arrays.stream(players).toList();
        } catch (IOException e) {
            System.out.println("Brak pliku");
            return new ArrayList<>();
        }
    }
}
