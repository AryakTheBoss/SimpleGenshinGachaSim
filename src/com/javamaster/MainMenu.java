package com.javamaster;

import javax.swing.*;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainMenu {
    private JButton childeBannerButton;
    private JButton kleeBannerButton;
    private JButton standardBannerButton;
    private JButton wishX10Button;
    private JButton wishX1Button;
    private JList list1;
    private JButton inventoryButton;
    private JPanel mainPanel;
    private JLabel bannerName;
    private JButton wishNTimesButton;
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private Banner currentBanner = new PremBanner();
    public MainMenu() {

        childeBannerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bannerName.setText("CHILDE BANNER");
                Counter c = currentBanner.getItemCounter();
                currentBanner = new ChildeBanner();
                currentBanner.copyCount(c);
            }
        });
        kleeBannerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bannerName.setText("KLEE BANNER");
                Counter c = currentBanner.getItemCounter();
                currentBanner = new KleeBanner();
                currentBanner.copyCount(c);
            }
        });
        standardBannerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bannerName.setText("STANDARD BANNER");
                Counter c = currentBanner.getItemCounter();
                currentBanner = new PremBanner();
                currentBanner.copyCount(c);
            }
        });
        wishX1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearList();
                addToJList(currentBanner.pull());
            }
        });
        wishX10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearList();
                for(int i=0;i<10;i++){
                    addToJList(currentBanner.pull());
                }
            }
        });
        inventoryButton.addActionListener(new ActionListener() {
            @Override //showMessageDialog​(Component parentComponent, Object message, String title, int messageType)
            public void actionPerformed(ActionEvent e) {
                String[] options = new String[] {"CLOSE", "RESET"};
                int response = JOptionPane.showOptionDialog(null, currentBanner.printStats(), "Inventory",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options, options[0]);
               // JOptionPane.showMessageDialog(null,currentBanner.printStats(),"Inventory",JOptionPane.WARNING_MESSAGE);
                if(response == 1){
                    currentBanner.reset();
                    JOptionPane.showMessageDialog(null,"Inventory has been reset.","Inventory Reset",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        wishNTimesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String s = JOptionPane.showInputDialog("How many times to pull?");

               try {
                   int n = Integer.parseInt(s);
                   Counter thisCustom = new Counter();
                   String cc = "";
                   for(int i=0;i<n;i++){
                     cc = currentBanner.pull();
                     if(cc.substring(0,cc.lastIndexOf("*")+1).equals("* * * * *")){
                        thisCustom.countItem(new ItemCount(5,cc.substring(cc.lastIndexOf("*")+1)));
                     }else{
                         thisCustom.countItem(new ItemCount(4,cc.substring(cc.lastIndexOf("*")+1)));
                     }
                       thisCustom.incrementPulls();
                   }
                   JOptionPane.showMessageDialog(null,thisCustom.printStats(),"Result of this Custom Pull",JOptionPane.INFORMATION_MESSAGE);
               }catch(NumberFormatException f){
                   JOptionPane.showMessageDialog(null,"That's not a number you dingus >:(");
               }

            }
        });
    }


    public JPanel returnMain(){
        return mainPanel;
    }
    public void addToJList(String element){
        listModel.addElement(element);
        list1.setModel(listModel);
    }
    public void clearList(){
       listModel.clear();
    }
/*ArrayList<Item> i = g.getItems();
 Vector itemsVector = new Vector(i);
 JList items = new JList(iemsVector); */
    private void createUIComponents() {
        // TODO: place custom component creation code here
        list1 = new JList<>();
        bannerName = new JLabel("STANDARD BANNER");


    }
}
