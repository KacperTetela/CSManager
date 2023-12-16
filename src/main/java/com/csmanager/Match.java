package com.csmanager;

public class Match {
    private LineUp lineUp1;
    private LineUp lineUp2;
    private int team1Score;
    private int team2Score;

    public Match(LineUp lineUp1, LineUp lineUp2) {
        this.lineUp1 = lineUp1;
        this.lineUp2 = lineUp2;
        team1Score = 0;
        team2Score = 0;
    }

    public LineUp getTeam1() {
        return lineUp1;
    }

    public LineUp getTeam2() {
        return lineUp2;
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
