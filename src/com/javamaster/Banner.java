package com.javamaster;

import java.util.ArrayList;

public interface Banner {



    String pull();
    void reset();
    void setPities(int four,int five);

    void printPity();
    void printStats();
    void copyCount(Counter ic);
    Counter getItemCounter();

}
