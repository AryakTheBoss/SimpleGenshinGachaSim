package com.javamaster;

public class ItemCount {

    private int stars;
    private String name;
    private int count;

    public ItemCount(int stars,String name){
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
        if(other instanceof ItemCount){
           ItemCount ic = (ItemCount) other;
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
