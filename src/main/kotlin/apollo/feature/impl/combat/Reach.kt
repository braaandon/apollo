package apollo.feature.impl.combat

import apollo.sdk.Player
import apollo.feature.impl.Feature

/*
 * 1.17.10 reach address:
 * libminecraftpe.so+1768B4C
*/

object Reach : Feature("Reach") {
    override fun on_loop() {
        Player.setReach(7.0f)
    }
}
