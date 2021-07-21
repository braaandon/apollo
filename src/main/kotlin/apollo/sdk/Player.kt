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
            Game.mod_base + 0x09872110,
            arrayListOf(0x18, 0x88, 0x80, 0x78, 0x40, 0x248, 0x268)
        )

        val mem = Memory(Float.SIZE_BYTES.toLong())
        mem.setFloat(0, value)
        Game.write(sp + 0x84, mem)
        Game.write(mp + 0x84, mem)
    }
}
