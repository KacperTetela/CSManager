package com.csmanager.utils;

import com.csmanager.model.roles.roleType.RoleType;
import com.csmanager.model.player.Player;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Utils {
    public static String createMapDisplay(Map<RoleType, Double> map) {
        String string = "";
        for (RoleType roleType : map.keySet()) {
            double val = map.get(roleType);
            string += String.format(" %s : %.1f %% ", roleType, val * 100);
        }
        return "[" + string + "]";
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
        return string;
    }

    public static String askAboutString(String question) {
        System.out.println(question + ":\n");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static boolean askAboutboolean(String question) {
        System.out.println(question + ":\n");
        System.out.println("Answer YES or NO");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if ((s.equalsIgnoreCase("YES")) || s.equalsIgnoreCase("1")) {
            return true;
        } else if ((s.equalsIgnoreCase("NO")) || s.equalsIgnoreCase("2")) {
            return false;
        } else {
            return askAboutboolean(question);
        }
    }

    public static int askAboutInt(String question) {
        System.out.println(question + ":\n");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
