package com.csmanager.model.roles;

import com.csmanager.model.Match;
import com.csmanager.model.Stage;
import com.csmanager.model.lineup.Side;

public class Roles {
    private Role CTRole;
    private Role TRole;

    public Roles(Role CTRole, Role TRole) {
        this.CTRole = CTRole;
        this.TRole = TRole;
    }

    private Role getRoleByStage(Stage stage) {
        if (stage == Stage.CT)
            return CTRole;
        else return TRole;
    }

    private double getSkill(Match match) {
        Role role = getRoleByStage(match.getStage());
        return role.calculateSkill(match);
    }
}
