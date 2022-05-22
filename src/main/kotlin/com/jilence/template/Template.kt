package com.jilence.template

import com.jilence.template.utils.Config
import net.axay.kspigot.main.KSpigot

class Template : KSpigot() {

    /**
     * is called when the plugin is loading on startup
     */
    override fun load() {

        /**
         * create or load the config
         */
        Config().create()

    }

    /**
     * is called when the plugin is finished loading
     */
    override fun startup() {

    }

    /**
     * is called when the server shuts down
     */
    override fun shutdown() {

    }

}