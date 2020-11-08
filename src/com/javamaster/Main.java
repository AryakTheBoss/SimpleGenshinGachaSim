package com.javamaster;

import java.util.Scanner;

public class Main {


    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        int choice = 0;
        int stars5 = 0;
        int stars4 = 0;
        PremBanner pb = new PremBanner();
        while(true) {
            System.out.println("Genshin Pull Sim 2.0 // ~~~~");
            System.out.println("\n1. Pull Single");
            System.out.println("2. Pull Multi");
            System.out.println("3. Pull Custom");
            System.out.println("4. Set Pity Counter");
            System.out.println("5. Check Pity Counters");
            System.out.println("6. Check Stats");
            System.out.println("7. Reset");
            System.out.println("8. Quit");
            choice = s.nextInt();


            switch(choice){

                case 1:

                    System.out.println(pb.pull());
                    System.out.println("\n"+"STATS: ");
                    pb.printStats();
                    System.out.println("\nPulls So far: "+pb.getPulls());
                    System.out.println("Primogems Spent: "+(pb.getPulls()*160));
                    System.out.println("APPROX ~$"+((((float)pb.getPulls()*160.0)/(6480.0+1600.0))*106.61)+"\n");

                    break;
                case 2:
                    for(int i=0;i<10;i++){
                        System.out.println(pb.pull());
                    }
                    System.out.println("\n"+"STATS: ");
                    pb.printStats();
                    System.out.println("\nPulls So far: "+pb.getPulls());
                    System.out.println("Primogems Spent: "+(pb.getPulls()*160));
                    System.out.println("APPROX ~$"+((((float)pb.getPulls()*160.0)/(6480.0+1600.0))*106.61)+"\n");
                    break;
                case 3:
                    System.out.println("Enter number of pulls: ");
                    int k = s.nextInt();
                    for(int i=0;i<k;i++){
                        System.out.println(pb.pull());
                    }
                    System.out.println("\n"+"STATS: ");
                    pb.printStats();
                    System.out.println("\nPulls So far: "+pb.getPulls());
                    System.out.println("Primogems Spent: "+(pb.getPulls()*160));
                    System.out.println("APPROX ~$"+((((float)pb.getPulls()*160.0)/(6480.0+1600.0))*106.61)+"\n");
                    break;
                case 4:
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
                case 5:
                        pb.printPity();
                    break;
                case 6:
                    System.out.println("\n"+"STATS: ");
                    pb.printStats();
                    System.out.println("\nPulls So far: "+pb.getPulls());
                    System.out.println("Primogems Spent: "+(pb.getPulls()*160));
                    System.out.println("APPROX ~$"+((((float)pb.getPulls()*160.0)/(6480.0+1600.0))*106.61)+"\n");
                    break;
                case 7:
                    System.out.println("Reset Pulls.");
                    pb.reset();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("idk what you just typed lol");

            }



        }
    }

}
