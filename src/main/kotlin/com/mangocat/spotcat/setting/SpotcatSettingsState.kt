package com.mangocat.spotcat.setting

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.*
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
    name = "SpotCatSettings",
    storages = [Storage("spotcat_settings.xml")]
)

@Service(Service.Level.APP)
class SpotcatSettingsState : PersistentStateComponent<SpotcatSettingsState> {

    var showTitle: Boolean = true
    var iconGap: Int = 4
    var customLabel: String = "MangoCat"

    override fun getState(): SpotcatSettingsState = this

    override fun loadState(state: SpotcatSettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }

    companion object {
        fun getInstance(): SpotcatSettingsState =
            ApplicationManager.getApplication().getService(SpotcatSettingsState::class.java)
    }
}