package com.csmanager.utils;

import com.github.javafaker.Faker;

public class NicknamesFaker {
    private final Faker faker = new Faker();

    public String getName() {
        String firstElement = faker.name().firstName();
        int firstElementCuttingLength = firstElement.length() / 2;
        return firstElement.substring(0, firstElementCuttingLength);
    }

    public String getSecondName() {
        String secondElement = faker.name().username();
        System.out.println(secondElement);
        int secondElementCuttingLength = secondElement.length() / 2;
        return secondElement.substring(0, secondElementCuttingLength);
    }


    public static void main(String[] args) {
        NicknamesFaker nicknamesFaker = new NicknamesFaker();
        //System.out.println(nicknamesFaker.getName());
        System.out.println(nicknamesFaker.getSecondName());
    }
}
