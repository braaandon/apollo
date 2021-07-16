package apollo.util

import java.io.File
import com.github.jonatino.natives.unix.*

class Process {
    var _pid: Int = 0

    init {
        File("/proc/").listFiles().forEach {
            val pid = it.path
                .substring(6)
                .toIntOrNull()

            if(pid == null) {
                return@forEach
            }
                        
            if("mcpelauncher" in 
                File("/proc/$pid/cmdline").readText()) {
                _pid = pid
            }
        }
    }
}