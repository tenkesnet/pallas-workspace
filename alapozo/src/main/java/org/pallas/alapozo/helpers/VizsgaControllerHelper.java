package org.pallas.alapozo.helpers;

public class VizsgaControllerHelper {

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
