package com.csmanager.model.match;

public enum MatchStage {
    T,
    CT,
    ENDED;

    protected void updateStage(Match match) {
        if (match.getCurrentRoundNumber() == 0)
            match.setMatchStage(ENDED);
        else if (match.getCurrentRoundNumber() <= 12)
            match.setMatchStage(CT);
        else
            match.setMatchStage(T);
    }

    protected boolean isMatchLive(Match match) {
        if (match.getCurrentRoundNumber() <= 24)
            return true;
        return false;
    }
}
