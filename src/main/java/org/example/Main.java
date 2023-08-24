package org.example;




public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> runGui(args));
    }

    private static void runGui(String[] args) {
        ImageFrame imageFrame = new ImageFrame(args);
        imageFrame.setLocation(200,200);

    }
}