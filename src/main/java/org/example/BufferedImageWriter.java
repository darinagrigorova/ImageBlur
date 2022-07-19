package org.example;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface BufferedImageWriter {
    void write(BufferedImage bufferedImage) throws IOException;
}
