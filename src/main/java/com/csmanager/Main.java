package com.csmanager;

import com.csmanager.carrer.CareerService;
import com.csmanager.carrer.ShopCreator;
import com.csmanager.carrer.Team;
import com.csmanager.carrer.TournamentCreator;
import com.csmanager.carrer.startingLineUp.LineUp;
import com.csmanager.carrer.startingLineUp.Role;
import com.csmanager.carrer.startingLineUp.LineUpPlayer;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CareerService careerService = new CareerService();
        careerService.start();
    }
}
