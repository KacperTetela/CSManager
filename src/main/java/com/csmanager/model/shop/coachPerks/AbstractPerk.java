package com.csmanager.model.shop.coachPerks;

import com.csmanager.model.match.MatchRules;

public abstract class AbstractPerk implements Perk{
    MatchRules matchRules;

    public AbstractPerk(MatchRules matchRules) {
        this.matchRules = matchRules;
    }
}
