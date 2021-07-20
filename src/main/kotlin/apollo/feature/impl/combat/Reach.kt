package apollo.feature.impl.combat

import apollo.feature.impl.Feature
import apollo.sdk.Player
import javax.swing.JPanel
import javax.swing.JSlider
import javax.swing.event.ChangeEvent

object Reach : Feature("Reach") {
    var modifier = 3.0f

    override fun onLoop() {
        Player.setReach(modifier)
    }

    override fun onRender(): JPanel {
        val panel = super.onRender()
        val slider = JSlider(300, 700)

        slider.addChangeListener({
            e ->
            val source = e.getSource() as JSlider
            modifier = (source.getValue().toFloat() / 100)
        })

        panel.add(slider)
        return panel
    }
}
