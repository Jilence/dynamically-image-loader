package com.jilence.loader

import com.jilence.loader.processor.ImageProcessor
import com.jilence.loader.processor.Pixel
import com.jilence.loader.processor.SkinLoader
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.md_5.bungee.api.ChatColor
import java.awt.image.BufferedImage

/**
 * Builds a representation of an image using icons and colors.
 */
class IconBuilder {

    private var username: String? = null
    private var image: BufferedImage? = null

    /**
     * Creates a string representation of an image using icons.
     * @param image The image to represent.
     * @return A String representation of the image.
     */
    fun createIconRepresentation(image: BufferedImage, ascent: Int = 5): String {
        val stringBuilder = StringBuilder()

        for (y in 0 until image.height) {
            for (x in 0 until image.width) {
                val pixel = Pixel(image, x, y, ascent)
                val icon = pixel.getIcon()
                stringBuilder.append(ChatColor.of(pixel.getColor()).toString())
                stringBuilder.append(icon)
                if (x != image.width - 1) stringBuilder.append("\uE3E2")
            }
            stringBuilder.append("\uE3E3\uE3E3\uE3E3\uE3E3\uE3E2")
        }
        return stringBuilder.toString().trim()
    }

    /**
     * Creates a string representation of an image using icons.
     * @param image The image to represent.
     * @return A Component representation of the image.
     */
    fun createIconRepresentationAsComponent(image: BufferedImage): Component {
        var component = Component.empty()
        for (y in 0 until image.height) {
            for (x in 0 until image.width) {
                val pixel = Pixel(image, x, y, 5)
                val icon = pixel.getIcon()
                val pixelColor = TextColor.color(pixel.getColor().rgb)

                component = component.append(Component.text(icon, pixelColor))

                if (x != image.width - 1) {
                    component = component.append(Component.text("\uE3E2"))
                }
            }

            component = component.append(Component.text("\uE3E3\uE3E3\uE3E3\uE3E3\uE3E2"))
        }

        return component
    }

    class Builder {
        private val iconBuilder = IconBuilder()

        fun withUsername(username: String) = apply {
            iconBuilder.username = username
            iconBuilder.image = SkinLoader().fetchPlayerSkin(username)?.let { ImageProcessor().extractHead(it) }
        }

        fun build(): String = iconBuilder.image?.let { iconBuilder.createIconRepresentation(it) } ?: error("Error: No image set")

        fun buildAsComponent(): Component {
            return iconBuilder.image?.let { iconBuilder.createIconRepresentationAsComponent(it) } ?: error("Error: No image set")
        }
    }

}
