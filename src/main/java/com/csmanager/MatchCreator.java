package com.csmanager;

public class MatchCreator {
    private LineUpCreator lineUpCreator;

    public MatchCreator(LineUpCreator lineUpCreator) {
        this.lineUpCreator = lineUpCreator;
    }

    public Match createMatch() {
        LineUp lineUp1 = lineUpCreator.getTeams().get(0);
        LineUp lineUp2 = lineUpCreator.getTeams().get(1);
        Match match = new Match(lineUp1, lineUp2);
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