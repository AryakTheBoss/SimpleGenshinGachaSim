package com.javamaster;

import java.util.Scanner;

public class Main {


    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        int choice = 0;
        int stars5 = 0;
        int stars4 = 0;
        System.out.println("Genshin Pull Sim 2.0 // ~~~~");
        System.out.println("1. Standard");
        System.out.println("2. Klee");
        System.out.println("Pick Banner to Summon from: ");
        int j = s.nextInt();
        Banner bann = null;
        if(j == 1){
            bann = new PremBanner();
        }else if(j == 2){
            bann = new KleeBanner();
        }else{
            System.out.println("Unknown option picked. set to default banner. You can change in the next Menu.");
            bann = new PremBanner();
        }

        String re = "";
        while(true) {

            System.out.println("Genshin Pull Sim 2.0 // ~~~~");
            System.out.println("CURRENT BANNER: "+(bann instanceof PremBanner ? "Standard Banner":"Klee Banner")+"\n");
            System.out.println("\n1. Pull Single");
            System.out.println("2. Pull Multi");
            System.out.println("3. Pull Custom");
            System.out.println("4. Set Pity Counter");
            System.out.println("5. Check Pity Counters");
            System.out.println("6. Check Stats");
            System.out.println("7. Reset");
            System.out.println("8. Change Banner (Copies Stats)");
            System.out.println("9. Quit");
            choice = s.nextInt();


            switch(choice){

                case 1:

                     re = bann.pull();
                    if(re.substring(0,re.lastIndexOf("*")+1).equals("* * * * *")){
                        System.out.println("~~~~!!  "+re+"  !!~~~~");
                    }else{
                        System.out.println(re);
                    }


                    break;
                case 2:

                    for(int i=0;i<10;i++){
                        re = bann.pull();
                        if(re.substring(0,re.lastIndexOf("*")+1).equals("* * * * *")){
                            System.out.println("~~~~!!  "+re+"  !!~~~~");
                        }else{
                            System.out.println(re);
                        }
                    }

                    break;
                case 3:
                    System.out.println("Enter number of pulls: ");
                    int k = s.nextInt();
                    for(int i=0;i<k;i++){
                        re = bann.pull();
                        if(re.substring(0,re.lastIndexOf("*")+1).equals("* * * * *")){
                            System.out.println("~~~~!!  "+re+"  !!~~~~");
                        }else{
                            System.out.println(re);
                        }
                    }

                    break;
                case 4:
                    System.out.println("Enter 4 or 5: ");
                    int y = s.nextInt();
                    if(y == 4){
                        bann.setPities(9,0); //next item will be 4 star
                    }else if(y == 5){
                        bann.setPities(0,89); //next item will be 5 star
                    }else{
                        bann.setPities(9,89); //next item with be a 5 star followed by 4 star
                    }
                    break;
                case 5:
                        bann.printPity();
                    break;
                case 6:

                    bann.printStats();

                    break;
                case 7:
                    System.out.println("Reset Pulls.");
                    bann.reset();
                    break;
                case 8:
                    System.out.println("Pick Banner to Summon from: ");
                    System.out.println("1. Standard");
                    System.out.println("2. Klee");
                    j=s.nextInt();
                    if(j == 1){
                        Counter c = bann.getItemCounter();
                        bann = new PremBanner();
                        bann.copyCount(c);
                    }else if(j == 2){
                        Counter c = bann.getItemCounter();
                        bann = new KleeBanner();
                        bann.copyCount(c);
                    }else{
                        System.out.println("Invalid. Staying on Current Banner.");
                    }
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("idk what you just typed lol");

            }



        }
    }

}
