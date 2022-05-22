package com.jilence.template.utils

import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException

/**
 * create a config.yml file in the plugins/timer folder
 */

lateinit var configFile: YamlConfiguration

private const val path = "./plugins/timer/"
private const val children = "config.yml"

private val file = File(path, children)

class Config {
    fun create() {
        val dir = File(path)
        if (!dir.exists()) {
            dir.mkdirs()
        }
        if (!file.exists()) {
            try {
                file.createNewFile()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        configFile = YamlConfiguration.loadConfiguration(file)
    }
}

fun YamlConfiguration.setAny(path: String?, `object`: Any?) {
    configFile[path!!] = `object`
    try {
        configFile.save(file)
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

fun YamlConfiguration.switchBoolean(path: String) {
    val boolean = getBooleanOrSet(path, false)
    setAny(path, !boolean)
}

fun YamlConfiguration.getBooleanOrSet(path: String, set: Boolean) : Boolean {
    if(configFile.get(path) == null) {
        setAny(path, set)
        return set
    }
    return configFile.getBoolean(path)
}

fun YamlConfiguration.getIntOrSet(path: String, set: Int) : Int {
    if(configFile.get(path) == null) {
        setAny(path, set)
        return set
    }
    return configFile.getInt(path)
}