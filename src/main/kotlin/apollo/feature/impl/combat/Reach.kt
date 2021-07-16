package apollo.feature.impl.combat

import apollo.feature.impl.Feature

class Reach : Feature("Reach") {
    override fun on_loop() {
        println("Hello from Reach")
    }
}