package org.example;




public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> runGui(args));
    }

    private static void runGui(String[] args) {
        new ImageFrame(args);
    }
}