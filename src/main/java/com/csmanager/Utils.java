package com.csmanager;

import com.csmanager.carrer.startingLineUp.Role;

import java.util.List;
import java.util.Map;

public class Utils {
    public static String createMapDisplay(Map<Role, Double> map) {
        String string = "";
        for (Role role : map.keySet()) {
            double val = map.get(role);
            string += String.format(" %s : %.1f %% ",role,val*100);
        }
        return "["+string+"]" ;
    }

    public static String createListDisplay(List<Player> list) {
        String string = "";
        for (int i = 0; i < list.size(); i++) {
            Player player = list.get(i);
            if (i != 0) {
                string += "\n";
            }
            string += player.toString();
        }
        return  string;
    }
}
