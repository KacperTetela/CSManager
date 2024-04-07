package com.csmanager.model.player.roles.roles;

import com.csmanager.model.match.Match;
import com.csmanager.model.match.MatchStage;

public class RolesBoth {
    private Role CTRole;
    private Role TRole;

    public RolesBoth(Role CTRole, Role TRole) {
        this.CTRole = CTRole;
        this.TRole = TRole;
    }

    public Role getRoleByMatchStage(MatchStage matchStage) {
        if (matchStage == MatchStage.CT)
            return CTRole;
        else return TRole;
    }

    public double getSkill(Match match) {
        Role role = getRoleByMatchStage(match.getMatchStage());
        return role.calculateSkill(match);
    }
}
