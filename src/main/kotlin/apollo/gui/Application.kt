package apollo.gui

import apollo.feature.FeatureManager
import apollo.feature.impl.combat.Reach
import apollo.feature.impl.movement.Speed
import javax.swing.JFrame
import javax.swing.JTabbedPane
import kotlin.concurrent.thread

class Application : JFrame() {
    val fm = FeatureManager(Reach, Speed)

    init {
        setTitle("Apollo")
        setResizable(false)
        setLocationRelativeTo(null)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    }

    private fun render() {
        val pane = JTabbedPane()

        fm.features.forEach {
            pane.addTab(it.name, it.onRender())
        }

        add(pane)
        pack()

        isVisible = true
    }

    fun run() {
        thread(start = true) {
            while (true) {
                fm.features.forEach {
                    if (it.toggled) {
                        it.onLoop()
                    }

                    Thread.sleep(250)
                }
            }
        }

        thread(start = true) {
            render()
        }
    }
}
