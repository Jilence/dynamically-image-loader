package com.jilence.loader.processor

import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import java.io.IOException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import javax.imageio.ImageIO

/**
 * Handles fetching and processing player skins.
 */
class SkinLoader {

    /**
     * Fetches a player skin from a URL.
     * @param playerName The player name to fetch the skin for.
     * @return A BufferedImage of the player's skin or null if an error occurs.
     */
    fun fetchPlayerSkin(playerName: String): BufferedImage? {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://mineskin.eu/skin/$playerName"))
            .build()

        return try {
            val response = client.send(request, HttpResponse.BodyHandlers.ofByteArray())
            val imageBytes = response.body()
            ImageIO.read(ByteArrayInputStream(imageBytes))
        } catch (e: IOException) {
            e.printStackTrace()
            null
        } catch (e: InterruptedException) {
            e.printStackTrace()
            Thread.currentThread().interrupt()
            null
        }
    }
}