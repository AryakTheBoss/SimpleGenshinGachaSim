package com.javamaster;

import javax.swing.*;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                JOptionPane.showMessageDialog(null,currentBanner.printStats(),"Inventory",JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {

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
