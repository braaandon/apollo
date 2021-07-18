package apollo.feature.impl.combat

import apollo.feature.impl.Feature

object Reach : Feature("Reach") {
    override fun on_loop() {
        println("Hello from Reach")
    }
}