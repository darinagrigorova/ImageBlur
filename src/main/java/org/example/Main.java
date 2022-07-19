package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Arrays;

/**
 * @author Miroslav Kovachev
 * ${DATE}
 * Methodia Inc.
 */
public class Main {

    public static void main(String[] args) {
        try {
            final Class<Main> mainClass = Main.class;
            final ClassLoader classLoader = mainClass.getClassLoader();
            final URL imageUrl = classLoader.getResource("download.jpg");
            final BufferedImage bufferedImage = ImageIO.read(imageUrl);
            final String oututPath = classLoader.getResource("").getPath();
            final File outputFIle = new File(oututPath + "/blurred.jpg");
            FilteredImage blurredImage = new FilteredImage();
            FileImageWriter fileImageWriter = new FileImageWriter(outputFIle);
            fileImageWriter.write(blurredImage.filter(bufferedImage));
            final String oututPath1 = classLoader.getResource("").getPath();
            final File outputFIle1 = new File(oututPath1 + "/blurredImageFilter.jpg");
            FileImageWriter fileImageWriter1 = new FileImageWriter(outputFIle1);
            BlurredImage blurredImage1 = new BlurredImage();
            fileImageWriter1.write(blurredImage1.filter(bufferedImage));



        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }


}