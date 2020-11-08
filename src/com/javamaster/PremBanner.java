package com.javamaster;

import java.util.Random;

public class PremBanner implements Banner {

    private int totalCurrentPulls;
    private int pity5Pulls;
    private int pity4Pulls;
    private Random gen;

    private static final String[] star5 = {"Diluc","Jean","Keqing","Mona","Qiqi",
            "Amos\' Bow","Aquila Favonia","Kunwu\'s Iris Rift","Lost Prayer TtSW","Primoridial JWS","Skyward Atlas","Skyward Blade","Skyward Harp","Skyward Pride","Skyward Spine","Wolf\'s Gravestone"};
    private static final String[] star4 = {"Sucrose","Chongyun","Noelle","Bennett","Fischl","Ningguang","Xingqiu","Beidou","Xiangling","Amber","Razor","Kaeya","Barbara","Lisa",
            "Rust","Sacrificial Bow","Stringless","Favonius War Bow","Eye of Perception","Sacrificial Frags","The Widsith","Favonius Codex","Favonius Lance","Dragon\'s Bane","Rainslasher","Sacrificial Greatsword","The Bell","Favonius Greatsword","Lion\'s Roar","Sacrificial Sword","The Flute","Favonius Sword"};
    private static final String[]  star3 = {"Slingshot","Sharpshooters Oath","Raven Bow","Emerald Orb","Thrilling ToDS","Magic Guide","Black Tassel","Debate Club","BloodTainted Greatsword","Ferrous Shadow","Skyrider Sword","Harbinger of Dawn","Cool Steel"};
//5star = 0.6% , 4star = 5.1%,  3star = 94.3%
    public PremBanner(){
        totalCurrentPulls = 0;
        pity5Pulls = 0;
        pity4Pulls = 0;
        gen = new Random();
    }

    @Override
    public String pull() {


            int n;

                totalCurrentPulls++;
                n = gen.nextInt(5000);

                if(pity() == 1){
                    pity5Pulls = 0;
                   // System.out.println("Pity 5: "+pity5Pulls+" Pity 4: "+pity4Pulls);
                    return "* * * * *  "+star5[gen.nextInt(star5.length)];
                }else if(pity() == 2){
                    pity4Pulls = 0;
                  //  System.out.println("Pity 5: "+pity5Pulls+" Pity 4: "+pity4Pulls);
                    return "* * * *  "+star4[gen.nextInt(star4.length)];
                }


                if(n >= 0 && n <= 30){
                    pity5Pulls = 0;
                   // System.out.println("Pity 5: "+pity5Pulls+" Pity 4: "+pity4Pulls);
                    return "* * * * *  "+star5[gen.nextInt(star5.length)];
                }else if(n >= 31 && n <= 286){ //255 vals
                    pity4Pulls = 0;
                   // System.out.println("Pity 5: "+pity5Pulls+" Pity 4: "+pity4Pulls);
                    return "* * * *  "+star4[gen.nextInt(star4.length)];
                }else{
                    pity5Pulls++;
                    pity4Pulls++;
                 //   System.out.println("Pity 5: "+pity5Pulls+" Pity 4: "+pity4Pulls);
                    return "* * *  "+star3[gen.nextInt(star3.length)];
                }




    }
    public void reset(){
        totalCurrentPulls = 0;
        pity5Pulls = 0;
        pity4Pulls = 0;
    }
    public void setRNGSeed(long seed){
        gen.setSeed(seed);
    }
        public void setPities(int four,int five){
        pity4Pulls = four;
        pity5Pulls = five;
        }
    public int getPulls(){
        return totalCurrentPulls;
    }
    public void printPity(){
        System.out.println("Pity 5: "+pity5Pulls+" Pity 4: "+pity4Pulls);
    }
    public int pity(){

        if(pity5Pulls % 90 == 0 && pity5Pulls != 0){
            return 1; //5 star pity
        }else if(pity4Pulls % 10 == 0 && pity4Pulls != 0){
            return 2; //4 star pity
        }else {
            return 0;
        }
    }


}
