package com.csmanager.model.tournament;

public class Tournament {
    private String name;
    private int prizepool;
    private MatchFormat matchFormat;
    private int numberOfTeams;

    /*
    jak okreslic ile taki turneij bedzie trwal
     */
    public Tournament(String name, int prizepool, MatchFormat matchFormat, int numberOfTeams) {
        this.name = name;
        this.prizepool = prizepool;
        this.matchFormat = matchFormat;
        this.numberOfTeams = numberOfTeams;
        if (numberOfTeams >= 8) {
            Tournament tournamentA = new Tournament("Group A", 0, matchFormat, numberOfTeams / 2);
            Tournament tournamentB = new Tournament("Group B", 0, matchFormat, numberOfTeams / 2);
        }

    }
    /**
     * Stworzyc klase z groupStagem
     * zrobic zeby dzialalo tournament i mialo jakis wplyw na rozgyrwke
     */
    @Override
    public String toString() {
        return "Tournament " +
                "name=" + name +
                " ,prizepool=" + prizepool + " \n";
    }
}
