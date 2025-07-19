package com.mangocat.spotcat.setting

interface SpotcatSettingsListener {
    fun onSettingsChanged()
}

object SpotcatSettingsBus {
    private val listeners = mutableListOf<SpotcatSettingsListener>()

    fun addListener(listener: SpotcatSettingsListener) {
        listeners.add(listener)
    }

    fun removeListener(listener: SpotcatSettingsListener) {
        listeners.remove(listener)
    }

    fun notifySettingsChanged() {
        listeners.forEach { it.onSettingsChanged() }
    }
}
