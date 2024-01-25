package com.csmanager;

import com.csmanager.carrer.Team;
import com.csmanager.carrer.startingLineUp.LineUp;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private LineUp lineUp1;
    private LineUp lineUp2;
    private int yourTeamLineUpScore;
    private int opponentScore;

    public Match(Team myTeam, LineUp yourTeamLineUp, LineUp opponent) {
        this.lineUp1 = yourTeamLineUp;
        this.lineUp2 = opponent;
        yourTeamLineUpScore = 0;
        opponentScore = 0;
        simulateMatch(this);
        displayMatchResult(this);

        //gracze po meczu musza wrocic do Teamu ktorym sterujemy. Musimy rozmontowac LineUp w celu odgarniecia graczy
        List<Player> playersToReturn = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            playersToReturn.add(yourTeamLineUp.getPlayers().get(i).getPlayer());
        }
        for (int i = 0; i < playersToReturn.size(); i++)
            myTeam.addPlayer(playersToReturn.get(i));
    }

    public LineUp getTeam1() {
        return lineUp1;
    }

    public LineUp getTeam2() {
        return lineUp2;
    }

    public int getTeam1Score() {
        return yourTeamLineUpScore;
    }

    public int getTeam2Score() {
        return opponentScore;
    }

    public void setTeam1Score(int team1Score) {
        this.yourTeamLineUpScore = team1Score;
    }

    public void setTeam2Score(int team2Score) {
        this.opponentScore = team2Score;
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
