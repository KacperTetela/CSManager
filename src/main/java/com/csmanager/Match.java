package com.csmanager;

public class Match {
    private Team team1;
    private Team team2;
    TeamCreator teamCreator;

    public Match(TeamCreator teamCreator) {
        this.teamCreator = teamCreator;
        team1 = teamCreator.getTeams().get(0);
        team2 = teamCreator.getTeams().get(1);
        simulateMatch();
        displayMatchResult();
    }

    public void simulateMatch() {
        if (team1.getTeamSkillLevel() > team2.getTeamSkillLevel()) {
            team1.setTeamScore(16);
            team2.setTeamScore(0);
        } else if (team1.getTeamSkillLevel() < team2.getTeamSkillLevel()) {
            team1.setTeamScore(0);
            team2.setTeamScore(16);
        } else {
            team1.setTeamScore(15);
            team2.setTeamScore(15);
        }
    }

    public void displayMatchResult() {
        System.out.println("Team 1: " + team1.getTeamScore() + " Team 2: " + team2.getTeamScore());
        if (team1.getTeamScore() > team2.getTeamScore()) {
            System.out.println("Team 1 wins!");
        } else if (team1.getTeamScore() < team2.getTeamScore()) {
            System.out.println("Team 2 wins!");
        } else {
            System.out.println("Draw!");
        }
    }

}
