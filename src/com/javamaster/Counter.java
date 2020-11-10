package com.javamaster;

import java.util.ArrayList;

public class Counter {

    private ArrayList<ItemCount> stats = new ArrayList<ItemCount>();
    private int totalCurrentPulls;

    public Counter(){
    totalCurrentPulls = 0;
    }
    public float estimateDollars(){
        return ((((float)totalCurrentPulls*160.0F)/(6480.0F+1600.0F))*106.61F);
    }
    public void incrementPulls(){
        totalCurrentPulls++;
    }
    public int getTotalCurrentPulls(){
        return totalCurrentPulls;
    }
    public void countItem(ItemCount i){
        for(ItemCount item : stats){
            if(item.equals(i)){
                item.increment();
                return;
            }
        }
        stats.add(i);

    }
        public void reset(){

                stats.clear();
                totalCurrentPulls = 0;

        }
    public void printStats(){

        if(stats.isEmpty()){
            System.out.println("You have no pulls lol");
            return;
        }
        for(ItemCount item : stats){
            System.out.println(item);
        }



    }


}
