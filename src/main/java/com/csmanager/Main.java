package com.csmanager;

public class Main {
    public static void main(String[] args) {
        PlayerCreator playerCreator = new PlayerCreator();
        LineUpCreator lineUpCreator = new LineUpCreator(playerCreator);
        MatchCreator matchCreator = new MatchCreator(lineUpCreator);
/*        matchCreator.createMatch();*/
    }
}
