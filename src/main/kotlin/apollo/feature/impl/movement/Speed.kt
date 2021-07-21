package apollo.feature.impl.movement

import apollo.feature.impl.Feature
import apollo.sdk.Player
import javax.swing.JPanel
import javax.swing.JSlider

object Speed : Feature("Speed") {
    var modifier = 0.1000000005f

    override fun onLoop() {
        Player.setSpeed(modifier)
    }

    override fun onRender(): JPanel {
        val panel = super.onRender()
        val slider = JSlider(100, 900)

        slider.addChangeListener({
            e ->
            val source = e.getSource() as JSlider
            modifier = (source.getValue().toFloat() / 1000)
        })

        panel.add(slider)
        return panel
    }
}
