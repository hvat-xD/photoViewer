package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class ImageFrame extends JFrame{
    Image baseImage;
    ImageObserver imageObserver;
    int baseImageHeight, baseImageWidth;
    double scale = 100;
    public ImageFrame(String[] args) {
        this.setTitle("Photo viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
            }
        });
        ImageIcon image;
        JLabel label = new JLabel();
        if (args.length > 0){
            image = new ImageIcon(args[0]);
            baseImage = image.getImage();
            imageObserver = image.getImageObserver();
            baseImageHeight = baseImage.getHeight(imageObserver);
            baseImageWidth = baseImage.getWidth(imageObserver);
            label.setIcon(image);
            this.addMouseWheelListener(e -> {


                double prevScale = scale;
                scale-=e.getScrollAmount() * e.getWheelRotation();

                Image newImg = getScaledImage(baseImage, (int)(baseImageWidth/100*scale), (int)(baseImageHeight/100*scale));
                image.setImage(newImg);
                this.pack();
                int pixDifW = (int)(baseImageWidth/100*scale) - (int)(baseImageWidth/100*prevScale);
                int pixDifH = (int)(baseImageHeight/100*scale) - (int)(baseImageHeight/100*prevScale);
                this.setLocation(this.getX() - pixDifW/2,
                        this.getY() - pixDifH/2);
                SwingUtilities.updateComponentTreeUI(this);
            });
        }else {
            label.setText("no file");
        }

        this.getContentPane().add(label);
        this.pack();

        this.setVisible(true);


    }
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
