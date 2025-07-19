package com.mangocat.spotcat.setting

import com.intellij.openapi.options.Configurable
import com.jgoodies.common.base.Objects
import javax.swing.JComponent

class SpotcatSettingsConfigurable : Configurable {

    private var settingsComponent: SpotcatSettingsComponent? = null

    override fun getDisplayName(): String = "Spotcat Settings"

    override fun createComponent(): JComponent {
        settingsComponent = SpotcatSettingsComponent()
        return settingsComponent!!.getPanel()
    }

    override fun isModified(): Boolean {
        val settings = SpotcatSettingsState.getInstance()
        return settingsComponent?.let {
            it.isShowTitle() != settings.showTitle ||
                    it.getIconGap() != settings.iconGap ||
                    !Objects.equals(it.getCustomLabel(), settings.customLabel)
        } ?: false
    }

    override fun apply() {
        val settings = SpotcatSettingsState.getInstance()
        settingsComponent?.let {
            settings.showTitle = it.isShowTitle()
            settings.iconGap = it.getIconGap()
            settings.customLabel = it.getCustomLabel()
        }

        // 🔔 notification status bar refresh
        println("通知状态栏刷新")
        SpotcatSettingsBus.notifySettingsChanged()
    }

    override fun reset() {
        val settings = SpotcatSettingsState.getInstance()
        settingsComponent?.let {
            it.setShowTitle(settings.showTitle)
            it.setIconGap(settings.iconGap)
            it.setCustomLabel(settings.customLabel)
        }
    }

    override fun disposeUIResources() {
        settingsComponent = null
    }

}