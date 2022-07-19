package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;

public class BlurredImage implements ImageFilter{

    @Override
    public BufferedImage filter(BufferedImage bufferedImage) {
        System.out.println("Enter color to filter the image. \nChoose between red, green and blue.");
        Scanner scanner = new Scanner(System.in);
        String colorFilter = scanner.nextLine();
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int p = bufferedImage.getRGB(x,y);
                Color color = new Color(bufferedImage.getRGB(x,y));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                if(colorFilter.equals("red")){
                int onlyRed = new Color(red, 0, 0).getRGB();
                    bufferedImage.setRGB(x, y, onlyRed);
                }else if(colorFilter.equals("green")) {
                    int onlyGreen = new Color(0, green, 0).getRGB();
                    bufferedImage.setRGB(x, y, onlyGreen);
                }else if(colorFilter.equals("blue")){
                int onlyBlue = new Color(0, 0, blue).getRGB();
                    bufferedImage.setRGB(x, y, onlyBlue);
                }


            }
        }

        return bufferedImage;
    }


}
