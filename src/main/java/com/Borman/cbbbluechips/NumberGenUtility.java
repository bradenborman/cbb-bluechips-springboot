package com.Borman.cbbbluechips;

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


}
