package com.javamaster;

import java.util.ArrayList;
import java.util.Random;

public class KleeBanner implements Banner { //TODO


    private int pity5Star;
    private int pity4Star;
    private boolean promo5G;
    private boolean promo4G;
    private Random gen;
    private Counter itemCounter;
    private static final String[] star5 = {"Diluc","Jean","Keqing","Mona","Qiqi"};//Klee, 4* Sucrose, Noelle, Xingqiu
    private static final String[] star4Promo = {"Sucrose","Noelle","Xingqiu"};
    private static final String[] star4 = {"Chongyun","Bennett","Fischl","Ningguang","Beidou","Xiangling","Amber","Razor","Kaeya","Barbara","Lisa",
            "Rust","Sacrificial Bow","Stringless","Favonius War Bow","Eye of Perception","Sacrificial Frags","The Widsith","Favonius Codex","Favonius Lance","Dragon\'s Bane","Rainslasher","Sacrificial Greatsword","The Bell","Favonius Greatsword","Lion\'s Roar","Sacrificial Sword","The Flute","Favonius Sword"};
    private static final String[]  star3 = {"Slingshot","Sharpshooters Oath","Raven Bow","Emerald Orb","Thrilling ToDS","Magic Guide","Black Tassel","Debate Club","BloodTainted Greatsword","Ferrous Shadow","Skyrider Sword","Harbinger of Dawn","Cool Steel"};
//5star = 0.6% , 4star = 5.1%,  3star = 94.3%

    public KleeBanner(){

        pity5Star = 0;
        pity4Star = 0;
        gen = new Random();
        itemCounter = new Counter();
        promo4G = false;
        promo5G = false;
    }

    @Override
    public void copyCount(Counter ic) {
        itemCounter = ic;
    }
    public Counter getItemCounter(){
        return itemCounter;
    }

    @Override
    public String pull() {

        int n;
        String name;
        itemCounter.incrementPulls();
        n = gen.nextInt(5000);
        // System.out.println("Result of pity() = "+pity()+" Pity4Pulls+1 = "+(pity4Pulls+1)+"<-- that %10 = "+((pity4Pulls+1)%10));
        if(pity() == 1){
            pity5Star = 0;
            // System.out.println("Pity 5: "+pity5Pulls+" Pity 4: "+pity4Pulls);

            if(promo5G){
                promo5G = false;
                name = "Klee";
                itemCounter.countItem(new ItemCount(5,name));
                return "* * * * * "+name;
            }
            int fiftyfifty = gen.nextInt(1);
            if(fiftyfifty == 1){
                promo5G = false;
                name = "Klee";
                itemCounter.countItem(new ItemCount(5,name));
                return "* * * * * "+name;
            }else{
               promo5G = true;
            }
            name = star5[gen.nextInt(star5.length)];
            itemCounter.countItem(new ItemCount(5,name));
            return "* * * * * "+name;

        }else if(pity() == 2){
            pity4Star = 0;
            pity5Star++;
            if(promo4G){
                promo4G = false;
                name = star4Promo[gen.nextInt(star4Promo.length)];
                itemCounter.countItem(new ItemCount(4,name));
                return "* * * * "+name;
            }
            int fiftyfifty = gen.nextInt(1);
            if(fiftyfifty == 1){
                promo4G = false;
                name = star4Promo[gen.nextInt(star4Promo.length)];
                itemCounter.countItem(new ItemCount(4,name));
                return "* * * * "+name;
            }else{
                promo4G = true;
            }
            //  System.out.println("Pity 5: "+pity5Pulls+" Pity 4: "+pity4Pulls);
            name = star4[gen.nextInt(star4.length)];
            itemCounter.countItem(new ItemCount(4,name));
            return "* * * * "+name;
        }


        if(n >= 0 && n <= 30){
            pity5Star = 0;
            if(promo5G){
                promo5G = false;
                name = "Klee";
                itemCounter.countItem(new ItemCount(5,name));
                return "* * * * * "+name;
            }
            int fiftyfifty = gen.nextInt(1);
            if(fiftyfifty == 1){
                promo5G = false;
                name = "Klee";
                itemCounter.countItem(new ItemCount(5,name));
                return "* * * * * "+name;
            }else{
                promo5G = true;
            }
            // System.out.println("Pity 5: "+pity5Pulls+" Pity 4: "+pity4Pulls);
            name = star5[gen.nextInt(star5.length)];
            itemCounter.countItem(new ItemCount(5,name));
            return "* * * * * "+name;
        }else if(n >= 31 && n <= 286){ //255 vals
            pity4Star = 0;
            pity5Star++;
            if(promo4G){
                promo4G = false;
                name = star4Promo[gen.nextInt(star4Promo.length)];
                itemCounter.countItem(new ItemCount(4,name));
                return "* * * * "+name;
            }
            int fiftyfifty = gen.nextInt(1);
            if(fiftyfifty == 1){
                promo4G = false;
                name = star4Promo[gen.nextInt(star4Promo.length)];
                itemCounter.countItem(new ItemCount(4,name));
                return "* * * * "+name;
            }else{
                promo4G = true;
            }
            // System.out.println("Pity 5: "+pity5Pulls+" Pity 4: "+pity4Pulls);
            name = star4[gen.nextInt(star4.length)];
            itemCounter.countItem(new ItemCount(4,name));
            return "* * * * "+name;
        }else{
            pity5Star++;
            pity4Star++;
            //   System.out.println("Pity 5: "+pity5Pulls+" Pity 4: "+pity4Pulls);
            // numOf3Stars++;
            return "* * * "+star3[gen.nextInt(star3.length)];
        }


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
    public void reset() {

        pity5Star = 0;
        pity4Star = 0;
        itemCounter.reset();
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

    @Override
    public void printStats() {
        System.out.println("\n"+"STATS: ");
        itemCounter.printStats();
        System.out.println("\nPulls So far: "+itemCounter.getTotalCurrentPulls());
        System.out.println("Primogems Spent: "+(itemCounter.getTotalCurrentPulls()*160));
        System.out.println("Approximate Money Spent (Includes NJ Sales Tax): ~$"+itemCounter.estimateDollars()+"\n");
    }
}
