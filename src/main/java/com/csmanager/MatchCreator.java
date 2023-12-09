package com.csmanager;

public class MatchCreator {
    private TeamCreator teamCreator;

    public MatchCreator(TeamCreator teamCreator) {
        this.teamCreator = teamCreator;
    }

    public Match createMatch() {
        Team team1 = teamCreator.getTeams().get(0);
        Team team2 = teamCreator.getTeams().get(1);
        Match match = new Match(team1, team2);
        simulateMatch(match);
        displayMatchResult(match);
        return match;
    }

    private void simulateMatch(Match match) {
        if (match.getTeam1().getTeamSkillLevel() > match.getTeam2().getTeamSkillLevel()) {
            match.setTeam1Score(16);
            match.setTeam2Score(0);
        } else if (match.getTeam1().getTeamSkillLevel() < match.getTeam2().getTeamSkillLevel()) {
            match.setTeam1Score(0);
            match.setTeam2Score(16);
        } else {
            match.setTeam1Score(15);
            match.setTeam2Score(15);
        }
    }

    private void displayMatchResult(Match match) {
        System.out.println("Team 1: " + match.getTeam1Score() + " Team 2: " + match.getTeam2Score());
        if (match.getTeam1Score() > match.getTeam2Score()) {
            System.out.println("Team 1 wins!");
        } else if (match.getTeam1Score() < match.getTeam2Score()) {
            System.out.println("Team 2 wins!");
        } else {
            System.out.println("Draw!");
        }
    }

}