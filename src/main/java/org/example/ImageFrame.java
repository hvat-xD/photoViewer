package org.example;

import javax.swing.*;

public class ImageFrame {
    public ImageFrame(String[] args) {
        JFrame frame = new JFrame("Photo viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image;
        JLabel label = new JLabel();
        if (args.length > 0){
            label.setText(args[0]);
            image = new ImageIcon(args[0]);
        }else {
            label.setText("no file");
            image = new ImageIcon();
        }
        label.setIcon(image);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setLocation(200,200);
        frame.setVisible(true);
    }
}
