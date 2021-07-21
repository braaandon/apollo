package apollo.sdk

import apollo.util.Process

object Game : Process("mcpelauncher") {
    val mod_base = getModule("libminecraftpe.so")
}
