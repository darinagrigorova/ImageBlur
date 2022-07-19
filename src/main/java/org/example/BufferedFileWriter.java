package org.example;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface BufferedFileWriter {
    void write(BufferedImage bufferedImage) throws IOException;
}
