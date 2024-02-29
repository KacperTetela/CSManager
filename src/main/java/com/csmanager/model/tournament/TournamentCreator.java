package com.csmanager.model.tournament;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TournamentCreator {
    Map<Integer, Tournament> tournaments = new HashMap<>();
    private String[] names = {"IEM Katowice 2021", "ESL Pro League 2021", "ESL One Cologne 2021",
            "BLAST Premier Spring 2021", "IEM Summer 2021", "ESL Pro League 2021", "ESL One Cologne 2021",
            "BLAST Premier Spring 2021", "IEM Summer 2021", "ESL Pro League 2021", "ESL One Cologne 2021",
            "BLAST Premier Spring 2021", "IEM Summer 2021", "ESL Pro League 2021", "ESL One Cologne 2021",
            "BLAST Premier Spring 2021", "IEM Summer 2021", "ESL Pro League 2021", "ESL One Cologne 2021",
            "BLAST Premier Spring 2021", "IEM Summer 2021", "ESL Pro League 2021", "ESL One Cologne 2021",
            "BLAST Premier Spring 2021", "IEM Summer 2021", "ESL Pro League 2021", "ESL One Cologne 2021",
            "BLAST Premier Spring 2021", "IEM Summer 2021", "ESL Pro League 2021", "ESL One Cologne 2021",
            "BLAST Premier Spring 2021", "IEM Summer 2021"};

    public TournamentCreator() {
        Arrays.stream(names).allMatch(name -> {
            //Tournament tournament = new Tournament(name, 100);
            //tournaments.put(tournaments.size(), tournament);
            return true;
        });
    }

    @Override
    public String toString() {
        return "tournaments=" + tournaments;
    }
}
