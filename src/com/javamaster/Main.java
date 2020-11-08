package com.javamaster;

import java.util.Scanner;

public class Main {


    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        int choice = 0;
        PremBanner pb = new PremBanner();
        while(true) {
            System.out.println("Genshin Pull Sim 1.0 // ~~~~");
            System.out.println("\n1. Pull Single");
            System.out.println("2. Pull Multi");
            System.out.println("3. Set Pity Counter");
            System.out.println("4. Check Pity Counters");
            System.out.println("5. Reset");
            System.out.println("6. Quit");
            choice = s.nextInt();


            switch(choice){

                case 1:
                    System.out.println(pb.pull());
                    System.out.println("\n\nPulls So far: "+pb.getPulls());

                    break;
                case 2:
                    for(int i=0;i<10;i++){
                        System.out.println(pb.pull());
                    }
                    System.out.println("\n\nPulls So far: "+pb.getPulls());
                    break;
                case 3:
                    System.out.println("Enter 4 or 5: ");
                    int y = s.nextInt();
                    if(y == 4){
                        pb.setPities(10,0);
                    }else if(y == 5){
                        pb.setPities(0,90);
                    }else{
                        pb.setPities(10,90);
                    }
                    break;
                case 4:
                        pb.printPity();
                    break;
                case 5:
                    System.out.println("Reset Pulls.");
                    pb.reset();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("idk what you just typed lol");

            }



        }
    }

}
