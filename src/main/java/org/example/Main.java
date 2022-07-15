package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;

/**
 * @author Miroslav Kovachev
 * ${DATE}
 * Methodia Inc.
 */
public class Main {

    public static void main(String[] args) {
        try{
            final Class<Main> mainClass = Main.class;
            final ClassLoader classLoader = mainClass.getClassLoader();
            final URL imageUrl = classLoader.getResource("download.jpg");
            final BufferedImage bufferedImage = ImageIO.read(imageUrl);
            final int height = bufferedImage.getHeight();
            final int width = bufferedImage.getWidth();
            final int rgb = bufferedImage.getRGB(0, 0);
            int blurRadius = 2;
            final BufferedImage blurredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = blurRadius; x < width - blurRadius; x++) {
                for (int y = blurRadius; y < height - blurRadius; y++) {
                    blurredImage.setRGB(x, y, getBlurredPixel(bufferedImage, x, y));
                }
            }

            final String oututPath = classLoader.getResource("").getPath();
            final File outputFIle = new File(oututPath + "/blurred.jpg");

            final FileOutputStream blurredImageOutputStream = new FileOutputStream(outputFIle);
            final boolean jpg = ImageIO.write(blurredImage, "jpg", blurredImageOutputStream);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }

    private static int getBlurredPixel(BufferedImage image, int x, int y) {
        final int rgb = image.getRGB(x, y);
        return rgb + 0x00_11_11_11;
    }

}