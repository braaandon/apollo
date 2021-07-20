package apollo.sdk

import com.sun.jna.Memory

object Player {
    fun setReach(value: Float) {
        val mem = Memory(Float.SIZE_BYTES.toLong())
        mem.setFloat(0, value)
        Game.process.write(Game.mod_base + 0x1768B4C, mem)
    }
}
