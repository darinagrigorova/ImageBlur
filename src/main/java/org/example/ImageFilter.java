package org.example;

import java.awt.image.BufferedImage;

public interface ImageFilter {
    BufferedImage filter(BufferedImage bufferedImage);
}
