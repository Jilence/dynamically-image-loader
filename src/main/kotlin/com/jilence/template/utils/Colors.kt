package com.jilence.template.utils

import net.kyori.adventure.text.format.TextColor

object Colors {

    /**
     * the plugin color
     */
    val color get() = "#FC8522"

    fun pluginColor() = TextColor.fromHexString(color)

    val BLUE = TextColor.fromHexString("#4079ff")
    val RED = TextColor.fromHexString("#FF5555")
    val YELLOW = TextColor.fromHexString("#fff200")
    val ORANGE = TextColor.fromHexString("#ffa200")
    val DARK_GRAY = TextColor.fromHexString("#3b3b3b")
    val GRAY = TextColor.fromHexString("#9c9c9c")
    val GREEN = TextColor.fromHexString("#41ff12")

}