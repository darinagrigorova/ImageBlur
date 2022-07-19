package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        File outputFIle1 = null;
        try {
            final Class<Main> mainClass = Main.class;
            final ClassLoader classLoader = mainClass.getClassLoader();
            final URL imageUrl = classLoader.getResource("download.jpg");
            final BufferedImage bufferedImage = ImageIO.read(imageUrl);
            //blurImage
            final String outputPath = classLoader.getResource("").getPath();
            final File outputFIle = new File(outputPath + "/blurFilter.jpg");
            BlurFilter blurredImage = new BlurFilter();
            FileImageWriter fileImageWriter = new FileImageWriter(outputFIle);
            fileImageWriter.write(blurredImage.filter(bufferedImage));
            //colorImage
            final String outputPath1 = classLoader.getResource("").getPath();
            outputFIle1 = new File(outputPath1 + "/colorFilter.jpg");
            FileImageWriter fileImageWriter1 = new FileImageWriter(outputFIle1);
            ColorFilter blurredImage1 = new ColorFilter();
            fileImageWriter1.write(blurredImage1.filter(bufferedImage));
            //both
            final String outputPath2 = classLoader.getResource("").getPath();
            final File outputFIle2 = new File(outputPath2 + "/bothFilter.jpg");
            FileImageWriter fileImageWriter2 = new FileImageWriter(outputFIle2);
            fileImageWriter2.write(blurredImage.filter(bufferedImage));

        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        BufferedImage printImage = ImageIO.read(outputFIle1);
        Printer printActionListener = new Printer(printImage);
        printActionListener.run();

    }

}