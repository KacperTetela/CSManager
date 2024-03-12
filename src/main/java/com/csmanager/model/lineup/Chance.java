package com.csmanager.model.lineup;

import com.csmanager.model.player.Player;

/**
 * The method is intended to provide the opportunity to significantly improve skill points for one match if the
 * player finds himself in the pool.
 * The method takes into account that the lower the potential coefficient, the lower the chance for a given player
 * to have an opportunity.
 * <p>
 * // 3 nooby, 2 koxy i 1 pro
 * <p>
 * // 0.2 - 0.25 // pro
 * // 0.1 - 0.2 // kox
 * // 0.05 - 0.1 // noob
 */
public class Chance {
    public static boolean isRequired(RoleType roleType, Player player) {
        if (player.getPotentialPoints().get(roleType) == null) {
            return false;
        }
        return true;
    }

    public static double calculate(RoleType roleType, Player player) {
        double isItTime = Math.random();
        if (isItTime <= player.getPotentialPoints().get(roleType)) {
            System.out.println("Dobrze idzie!  " + player.getName());
            if (player.getRolePoints().get(roleType) < 0.75)
                return 0.25;
            else
                return ((player.getRolePoints().get(roleType) + 0.25) % 1);
        }
        return player.getRolePoints().get(roleType);
    }
}
