package com.javamaster;

public class Item {

    private int stars;
    private String name;
    private int count;

    public Item(int stars, String name){
        count = 1;
        this.name = name;
        this.stars = stars;

    }

    public void increment(){
        count++;
    }
    public String getName(){
        return this.name;
    }
   public int getStars(){
        return this.stars;
   }
    public boolean equals(Object other){
        if(other instanceof Item){
           Item ic = (Item) other;
           if(ic.getName().equals(this.name) && ic.getStars() == stars){
               return true;
           }
        }
        return false;
   }

   public String toString(){
        return stars+"* "+name+": "+count;
   }
}
