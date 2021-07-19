package apollo.feature.impl.combat

import apollo.feature.impl.Feature
import com.sun.jna.Memory

/*
 * 1.17.10 reach address:
 * libminecraftpe.so+1768B4C
*/

object Reach : Feature("Reach") {
    override fun on_loop() {
        var mem = Memory(Float.SIZE_BYTES.toLong())
        mem.setFloat(0, 7.0f)
        game.process.write(game.mod_base + 0x1768B4C, mem)
    }
}
