package com.csmanager;

public class Match {
    private Team team1;
    private Team team2;
    private int team1Score;
    private int team2Score;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        team1Score = 0;
        team2Score = 0;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

}
