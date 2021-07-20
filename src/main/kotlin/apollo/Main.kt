package apollo

import apollo.gui.Window
import apollo.feature.FeatureManager
import apollo.feature.impl.combat.Reach

fun main() {
    val fm = FeatureManager(Reach)

    fm.features.forEach {
        while (true) {
            it.on_loop()
        }
    }
}
