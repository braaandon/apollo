package apollo.util

import java.io.File
import com.sun.jna.*
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

        println("Process ID: $_pid")
    }

    fun read(address: Long, size: Int): Memory {
        val buf = Memory(size.toLong())

        val local = unix.iovec()
        val remote = unix.iovec()

        local.iov_base = buf
        local.iov_len = size
    
        remote.iov_base = Pointer.createConstant(address)
        remote.iov_len = size

        unix.process_vm_readv(_pid, local, 1, remote, 1, 0)

        return buf
    }
}