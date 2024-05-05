package com.csmanager.utils;

import com.github.javafaker.Faker;

public class NicknamesFaker {
    private static final Faker faker = new Faker();

    public static String getNickname() {
        return getFirstElement() + getSecondElement();
    }

    private static String getFirstElement() {
        String firstElement = faker.name().firstName();
        int firstElementCuttingLength = firstElement.length() / 2;
        return firstElement.substring(0, firstElementCuttingLength);
    }

    private static String getSecondElement() {
        String secondElement = faker.name().username();
        String cutSecondElement = secondElement.substring(0, secondElement.indexOf('.'));
        return cutSecondElement.substring(0, cutSecondElement.length() / 2);
    }
}
