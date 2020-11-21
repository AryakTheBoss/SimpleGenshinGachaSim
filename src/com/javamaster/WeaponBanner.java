package com.javamaster;

import java.util.Random;

public class WeaponBanner implements Banner {

    private int pity5Star;
    private int pity4Star;
    private boolean promo5G;
    private boolean promo4G;
    private Random gen;
    private Counter itemCounter;
    private int currentBannerPulls;
    private static final String[] star5 = {"Weapons"}; //Other 5 stars
    private static final String[] star5Promo = {"Skyward Harp","Memory of Dust"}; //Featured 5 stars
    private static final String[] star4 = {"Weapons"}; //Other 4 stars
    private static final String[] star4Promo = {"Weapons"}; //Featured 4 stars
    private static final String[] star3 = {"Weapons"}; // 3 stars


    public WeaponBanner(){
        pity5Star = 0;
        pity4Star = 0;
        gen = new Random();
        itemCounter = new Counter();
        promo4G = false;
        promo5G = false;
        currentBannerPulls = 0;
    }

    @Override
    public String pull() {

        return null;

    }

    @Override
    public void reset() {
        pity5Star = 0;
        pity4Star = 0;
        itemCounter.reset();
        currentBannerPulls = 0;
    }

    @Override
    public void setPities(int four, int five) {
        pity4Star = four;
        pity5Star = five;
    }

    @Override
    public void printPity() {
        System.out.println("Pity 5: "+pity5Star+" Pity 4: "+pity4Star);
    }
    private int pity(){

        if((pity5Star+1) % 90 == 0){
            return 1; //5 star pity
        }else if((pity4Star+1) % 10 == 0){
            return 2; //4 star pity
        }else {
            return 0;
        }
    }

    @Override
    public String printStats() {

        String result = "";
        result += "STATS: \n";
        result += itemCounter.printStats();
        result += "Pulls So far: "+itemCounter.getTotalCurrentPulls()+" Pulls on this Banner: "+currentBannerPulls+"\n";
        result+= "Primogems Spent: "+(itemCounter.getTotalCurrentPulls()*160)+"\n";
        result+= "Approximate Money Spent (Includes NJ Sales Tax): ~$"+itemCounter.estimateDollars()+"\n";
        return result;
    }

    @Override
    public void copyCount(Counter ic) {
        itemCounter = ic;
    }

    @Override
    public Counter getItemCounter() {
        return itemCounter;
    }
}
