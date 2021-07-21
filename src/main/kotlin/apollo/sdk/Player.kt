package apollo.sdk

import com.sun.jna.Memory

object Player {
    fun setReach(value: Float) {
        val mem = Memory(Float.SIZE_BYTES.toLong())
        mem.setFloat(0, value)
        Game.write(Game.mod_base + 0x1768B4C, mem)
    }

    fun setSpeed(value: Float) {
        val sp = Game.resolveMultiLvl(
            Game.mod_base + 0x0976F950,
            arrayListOf(0x2E0, 0x218, 0x100, 0x8, 0x8, 0x290, 0x108)
        )

        val mp = Game.resolveMultiLvl(
            Game.mod_base + 0x098A78A8,
            arrayListOf(0x38, 0x8, 0x290, 0x48, 0x0, 0x38, 0x1D8)
        )

        val mem = Memory(Float.SIZE_BYTES.toLong())
        mem.setFloat(0, value)
        Game.write(sp + 0x84, mem)
        Game.write(mp + 0x84, mem)
    }
}
