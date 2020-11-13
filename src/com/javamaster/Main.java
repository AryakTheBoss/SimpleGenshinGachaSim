package com.javamaster;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import javax.swing.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args){

        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("Genshin Gacha Simulator 2.0 ~~ javamaster44");
        MainMenu mm = new MainMenu();
        frame.setContentPane(mm.returnMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);

    }

}
