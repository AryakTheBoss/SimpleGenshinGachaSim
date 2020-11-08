package com.javamaster;

import java.util.ArrayList;

public class Counter {

    private ArrayList<ItemCount> stats = new ArrayList<ItemCount>();

    public Counter(){

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

        }
    public void printStats(){


        for(ItemCount item : stats){
            System.out.println(item);
        }



    }

}
