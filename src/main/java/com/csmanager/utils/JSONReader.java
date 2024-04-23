package com.csmanager.utils;

import com.csmanager.model.player.builder.Player;
import com.csmanager.model.player.builder.PrefabricatedPlayerBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JSONReader {

    public static void main(String[] args) {
    }

    public static void read(Map<Player, Boolean> prefabricatedPlayers) {

        //jackson
        JSONParser jsonParser = new JSONParser();

        if (!prefabricatedPlayers.isEmpty()) {
           return;
        } else {
            //TODO make an update of Map
        }

        try {
            // Wczytaj tablicę JSON
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("C:\\Users\\kacpe\\" +
                    "IdeaProjects\\CSManager\\src\\main\\java\\com\\csmanager\\ProPlayers.json"));

            // Przetwarzaj każdy obiekt w tablicy
            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) object;

                // Pobierz dane z obiektu JSON
                String name = (String) jsonObject.get("name");
                int potentialPointsANCHOR = Integer.parseInt(jsonObject.get("potential_points_ANCHOR").toString());
                int rolePointsANCHOR = Integer.parseInt(jsonObject.get("role_points_ANCHOR").toString());

                int potentialPointsAWPER = Integer.parseInt(jsonObject.get("potential_points_AWPER").toString());
                int rolePointsAWPER = Integer.parseInt(jsonObject.get("role_points_AWPER").toString());

                int potentialPointsROTATOR = Integer.parseInt(jsonObject.get("potential_points_ROTATOR").toString());
                int rolePointsROTATOR = Integer.parseInt(jsonObject.get("role_points_ROTATOR").toString());

                int potentialPointsRIFLER = Integer.parseInt(jsonObject.get("potential_points_RIFLER").toString());
                int rolePointsRIFLER = Integer.parseInt(jsonObject.get("role_points_RIFLER").toString());

                int potentialPointsLURKER = Integer.parseInt(jsonObject.get("potential_points_LURKER").toString());
                int rolePointsLURKER = Integer.parseInt(jsonObject.get("role_points_LURKER").toString());

                // Wyświetl dane
                System.out.println("Name: " + name);
                System.out.println("potentialPointsANCHOR: " + potentialPointsANCHOR);
                System.out.println();

                double[][] roleTypeValues = new double[5][2];
                roleTypeValues[0][0] = ((double) potentialPointsANCHOR) / 10;
                roleTypeValues[0][1] = ((double) rolePointsANCHOR) / 10;
                roleTypeValues[1][0] = ((double) potentialPointsAWPER) / 10;
                roleTypeValues[1][1] = ((double) rolePointsAWPER) / 10;
                roleTypeValues[2][0] = ((double) potentialPointsROTATOR) / 10;
                roleTypeValues[2][1] = ((double) rolePointsROTATOR) / 10;
                roleTypeValues[3][0] = ((double) potentialPointsRIFLER) / 10;
                roleTypeValues[3][1] = ((double) rolePointsRIFLER) / 10;
                roleTypeValues[4][0] = ((double) potentialPointsLURKER) / 10;
                roleTypeValues[4][1] = ((double) rolePointsLURKER) / 10;

                PrefabricatedPlayerBuilder prefabricatedPlayerBuilder = new PrefabricatedPlayerBuilder();
                prefabricatedPlayerBuilder.name(name)
                        .roleTypeValues(roleTypeValues);
                Player player = prefabricatedPlayerBuilder.build();
                prefabricatedPlayers.put(player, false);
            }
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e.getMessage());
        } catch (org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
