package apollo.feature.impl

import java.awt.GridLayout
import javax.swing.JCheckBox
import javax.swing.JPanel

open class Feature(name: String) {
    val name = name
    var toggled = false

    open fun onLoop() { /*...*/ }
    open fun onRender(): JPanel {
        val panel = JPanel(GridLayout())
        val checkbox = JCheckBox("Toggle")
        checkbox.addItemListener { 
            e -> 
            val source = e.getSource() as JCheckBox
            toggled = source.isSelected() 
        }

        panel.add(checkbox)
        return panel
    }
}
