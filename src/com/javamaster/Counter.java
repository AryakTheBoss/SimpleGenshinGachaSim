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
    public String printStats(){

        if(stats.isEmpty()){

            return "You have no pulls lol";
        }
        String result = "";
        for(ItemCount item : stats){
           result += item+"\n";
        }
        return result;



    }


}
