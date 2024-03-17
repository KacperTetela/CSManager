package com.csmanager.model.match;

import com.csmanager.model.roster.Roster;
import com.csmanager.model.team.Team;

public class Match {
    private Team myTeam;
    private Roster managerRoster;
    private Roster computerRoster;
    private MatchStage matchStage;
    /**
     * The score int array is initialized to store the match result for two teams, respectively for
     * managerRoster, computerRoster
     * score[0] = managerScore
     * score[1] = computerScore
     */
    private int[] score;
    private int currentRoundNumber = 1;

    public Match(Team myTeam, Roster managerRoster, Roster computerRoster) {
        this.myTeam = myTeam;
        this.managerRoster = managerRoster;
        this.computerRoster = computerRoster;
        score = new int[2];
        matchStage = MatchStage.CT;
    }

    public void playMatch() {
        simulateMatch();
        displayMatchResult();
        applyProgress();
    }


    private void simulateMatch() { //TODO musimy to powtorzyc dla 1 rundy, 2 rundy i END
        double managerRosterSkill = managerRoster.getRosterSkillLevel(this);
        double opponentRosterSkill = computerRoster.getRosterSkillLevel(this);
        while (matchStage.isMatchLive(this)) {
            if (managerRosterSkill >= opponentRosterSkill)
                score[0]++;
            else
                score[1]++;
            currentRoundNumber++;
        }

        if (getMatchStage() == MatchStage.ENDED) {
            //
        }
        System.out.println(managerRosterSkill);
        System.out.println(opponentRosterSkill);
    }

    private void displayMatchResult() {
        System.out.println("\nLineUp 1: " + score[0] + " LineUp 2: " + score[1]);
        if (score[0] > score[1]) {
            System.out.println("You win\n");
        } else if (score[0] < score[1]) {
            System.out.println("You lose\n");
        } else {
            System.out.println("Draw!\n");
        }
    }

    private void applyProgress() {
        if (score[0] > score[1]) {
            myTeam.addMoney(100);
        }
        //
        managerRoster.trainPlayers();
    }

    public int getCurrentRoundNumber() {
        return currentRoundNumber;
    }

    public MatchStage getMatchStage() {
        return matchStage;
    }

    public void setMatchStage(MatchStage matchStage) {
        this.matchStage = matchStage;
    }
}

/*
Gracz - 2 role.
Roles - ma te dwie role i zarzadza dostepami do nich i przyjmuje mecz

* rozegraj 1 połowę
* rozegraj 2 połowę
* podlicz skille
*
*
*
*
*
*
*
* */