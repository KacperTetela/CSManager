package com.csmanager;

public class MainGUI {
    public static void main(String[] args) {
        PlayerCreator playerCreator = new PlayerCreator();
        TeamCreator teamCreator = new TeamCreator(playerCreator);
        MatchCreator matchCreator = new MatchCreator(teamCreator);
        matchCreator.createMatch();
    }
}
