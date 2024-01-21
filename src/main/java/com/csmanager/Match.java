package com.csmanager;

import com.csmanager.carrer.startingLineUp.LineUp;

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
        simulateMatch(this);
        displayMatchResult(this);
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

    private void simulateMatch(Match match) {
        if (match.getTeam1().getLineUpSkillLevel() > match.getTeam2().getLineUpSkillLevel()) {
            match.setTeam1Score(16);
            match.setTeam2Score(0);
        } else if (match.getTeam1().getLineUpSkillLevel() < match.getTeam2().getLineUpSkillLevel()) {
            match.setTeam1Score(0);
            match.setTeam2Score(16);
        } else {
            match.setTeam1Score(15);
            match.setTeam2Score(15);
        }
    }

    private void displayMatchResult(Match match) {
        System.out.println("LineUp 1: " + match.getTeam1Score() + " LineUp 2: " + match.getTeam2Score());
        if (match.getTeam1Score() > match.getTeam2Score()) {
            System.out.println("LineUp 1 wins!");
        } else if (match.getTeam1Score() < match.getTeam2Score()) {
            System.out.println("LineUp 2 wins!");
        } else {
            System.out.println("Draw!");
        }
    }

}
