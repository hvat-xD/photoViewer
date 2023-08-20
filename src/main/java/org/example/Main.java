package org.example;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> runGui(args));
    }

    private static void runGui(String[] args) {
        JFrame frame = new JFrame("Photo viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel();
        if (args.length > 0){
            label.setText(args[0]);
        }else {
            label.setText("no file");
        }
        frame.getContentPane().add(label);
        frame.pack();
        frame.setLocation(200,200);
        frame.setVisible(true);
    }
}