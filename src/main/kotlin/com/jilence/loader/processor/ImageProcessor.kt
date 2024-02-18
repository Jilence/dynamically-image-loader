package com.jilence.loader.processor

import java.awt.image.BufferedImage

/**
 * Provides methods for processing images, such as extracting parts of the image.
 */
class ImageProcessor {

    /**
     * Extracts the head from a player skin.
     * @param skin The player's skin as a BufferedImage.
     * @return A BufferedImage containing only the head of the skin.
     */
    fun extractHead(skin: BufferedImage): BufferedImage = skin.getSubimage(8, 8, 8, 8)
}