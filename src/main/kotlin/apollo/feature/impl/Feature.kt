package apollo.feature.impl

import java.awt.GridLayout
import javax.swing.JCheckBox
import javax.swing.JPanel

open class Feature(name: String) {
    val name = name
    val toggled = false

    open fun onLoop() { /*...*/ }
    open fun onRender(): JPanel {
        val panel = JPanel(GridLayout())
        val toggle = JCheckBox("Toggle")
        panel.add(toggle)
        return panel
    }
}
