package com.Borman.cbbbluechips.utilities;

import java.util.Random;

public class NumberGenUtility {



    public static String getRandomNumber() {
        Random rand = new Random();
        int x = rand.nextInt(75);
        return String.valueOf(x);
    }

    public static String getRandomPrice() {
        Random rand = new Random();
        int x = rand.nextInt(7000);
        return String.valueOf(x);
    }

    public static String getRandomPointSpread() {
        Random rand = new Random();
        int x = rand.nextInt(15);
        double y = Double.valueOf(String.valueOf(x)) / 2 ;
        return getRandomBoolean() ? String.valueOf(y) : String.valueOf((y * -1));
    }

    private static boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

}
