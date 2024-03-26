package com.csmanager.model.roster.rosterLock;

import com.csmanager.model.player.Player;
import com.csmanager.model.roles.roleType.RoleType;
import com.csmanager.model.roles.roleType.Side;
import com.csmanager.utils.Utils;

import java.util.*;

public class RosterRolesService2 {

    private List<RoleCounter> roleCounters = new ArrayList<>();

    public RosterRolesService2() {
        Arrays.stream(RoleType.values()).forEach(role ->{
            if (role.getSide() == Side.BOTH) {
                roleCounters.add(new RoleCounter(Side.T, role));
                roleCounters.add(new RoleCounter(Side.CT, role));
            } else {
                roleCounters.add(new RoleCounter(role.getSide(), role));
            }

        } );
    }


    public void select(List<Player> players) {
        for (Player player : players) {
            RoleType tRole = selectRoleForPlayer(player, Side.T);
            RoleType ctRole = selectRoleForPlayer(player, Side.CT);
            player.setRoles(tRole, ctRole);
        }
    }

    private RoleType selectRoleForPlayer(Player player, Side side) {
        String question = getQuestionForRoleSelection(player, side);
        int selectedNr = Utils.askAboutInt(question,1,availableRolesForSide(side).size());
        RoleCounter selectedRole = availableRolesForSide(side).get(selectedNr - 1);
        selectedRole.increment();
        return selectedRole.roleType;
    }

    private String getQuestionForRoleSelection(Player player, Side side) {
        String question = String.format("Select role for %s for side %s: \n", player.getName(),side);
        int count = 1;
        for (RoleCounter roleCounter : availableRolesForSide(side)) {
            question += String.format("%d. %s ", count++, roleCounter.roleType);
        }
        return question;
    }

    private List<RoleCounter> availableRolesForSide(Side side) {
        List<RoleCounter> availableRoles = new ArrayList<>();
        for (RoleCounter roleCounter : roleCounters) {
            if (roleCounter.side == side && !roleCounter.isFull()  ) {
                availableRoles.add(roleCounter);
            }
        }
        return availableRoles;
    }

   final class RoleCounter {
         Side side;
         RoleType roleType;
         int count = 0;

        public RoleCounter(Side side, RoleType roleType) {
            this.side = side;
            this.roleType = roleType;
        }

        void increment() {
            count++;
        }

        boolean isFull() {
            return count >= roleType.getMaxPerRoosterSide();
        }
    }

}
