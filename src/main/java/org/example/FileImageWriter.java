package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileImageWriter implements BufferedFileWriter {
        File file;

    public FileImageWriter(File file) {
        this.file = file;
    }

    @Override
    public void write(BufferedImage bufferedImage) throws IOException {
        final Class<Main> mainClass = Main.class;
        final ClassLoader classLoader = mainClass.getClassLoader();
        final String oututPath = classLoader.getResource("").getPath();
        final File outputFIle = new File(oututPath + "/blurred.jpg");
        final FileOutputStream blurredImageOutputStream = new FileOutputStream(file);
        final boolean jpg = ImageIO.write(bufferedImage, "jpg", blurredImageOutputStream);
    }
}
