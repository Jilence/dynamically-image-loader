package com.jilence.loader.processor

import java.awt.Color
import java.awt.image.BufferedImage

/**
 * Represents a pixel within an image, providing access to its color and associated icon.
 */
class Pixel(private val image: BufferedImage, private val x: Int, private val y: Int, private val ascent: Int) {

    /**
     * Gets the color of the pixel.
     * @return The Color of the pixel.
     */
    fun getColor(): Color = Color(image.getRGB(x, y), true)

    /**
     * Determines the icon associated with this pixel.
     * @return A String representing the icon.
     */
    fun getIcon(): String {
        return Icons.valueOf("ICON" + (y + 1 + ascent)).icon
    }
}
