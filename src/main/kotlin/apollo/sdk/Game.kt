package apollo.sdk

import apollo.util.Process

object Game {
    val process = Process("mcpelauncher")
    val mod_base = process.getModule("libminecraftpe.so")
}
