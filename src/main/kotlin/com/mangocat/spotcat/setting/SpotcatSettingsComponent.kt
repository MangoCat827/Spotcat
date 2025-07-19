package com.mangocat.spotcat.setting

import com.intellij.openapi.components.Service
import java.awt.Component
import java.awt.Dimension
import javax.swing.*

@Service
class SpotcatSettingsComponent {

    private val mainPanel = JPanel()
    private val showTitleCheckBox = JCheckBox("display song title")
    private val iconGapField = JTextField(4)
    private var customLabelField = JTextField(4)

    init {
        mainPanel.layout = BoxLayout(mainPanel, BoxLayout.Y_AXIS)
        mainPanel.border = BorderFactory.createEmptyBorder(10, 5, 10, 5)
        mainPanel.alignmentX = Component.LEFT_ALIGNMENT

        showTitleCheckBox.alignmentX = Component.LEFT_ALIGNMENT
        mainPanel.add(showTitleCheckBox)
        mainPanel.add(Box.createVerticalStrut(8))
        mainPanel.add(getIconGapPanel())
        mainPanel.add(Box.createVerticalStrut(8))
        mainPanel.add(getCustomLabelPanel())
    }

    private fun getCustomLabelPanel(): JPanel {
        customLabelField.maximumSize = Dimension(Int.MAX_VALUE, iconGapField.preferredSize.height)
        val customLabel = JPanel()
        customLabel.layout = BoxLayout(customLabel, BoxLayout.X_AXIS)
        customLabel.alignmentX = Component.LEFT_ALIGNMENT
        customLabel.maximumSize = Dimension(Int.MAX_VALUE, iconGapField.preferredSize.height)
        customLabel.add(JLabel("Custom label"))
        customLabel.add(Box.createHorizontalStrut(8))
        customLabel.add(customLabelField)
        return customLabel
    }

    private fun getIconGapPanel(): JPanel {
        iconGapField.maximumSize = Dimension(Int.MAX_VALUE, iconGapField.preferredSize.height)
        val iconGapPanel = JPanel()
        iconGapPanel.layout = BoxLayout(iconGapPanel, BoxLayout.X_AXIS)
        iconGapPanel.alignmentX = Component.LEFT_ALIGNMENT
        iconGapPanel.maximumSize = Dimension(Int.MAX_VALUE, iconGapField.preferredSize.height)
        iconGapPanel.add(JLabel("Spacing"))
        iconGapPanel.add(Box.createHorizontalStrut(8))
        iconGapPanel.add(iconGapField)
        return iconGapPanel
    }

    // return the panel to the IntelliJ settings system
    fun getPanel(): JPanel = mainPanel

    /** getters and setters */
    fun isShowTitle(): Boolean = showTitleCheckBox.isSelected

    fun setShowTitle(show: Boolean) {
        showTitleCheckBox.isSelected = show
    }

    fun getIconGap(): Int = iconGapField.text.toIntOrNull() ?: 4

    fun setIconGap(gap: Int) {
        iconGapField.text = gap.toString()
    }

    fun getCustomLabel(): String = customLabelField.text.toString() ?: ""

    fun setCustomLabel(customLabel: String) {
        customLabelField.text = customLabel
    }

}