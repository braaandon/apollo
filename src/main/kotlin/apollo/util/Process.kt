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
        var local = unix.iovec()
        var remote = unix.iovec()
        var buf = Memory(size.toLong())

        local.iov_base = buf
        local.iov_len = size
    
        remote.iov_base = Pointer.createConstant(address)
        remote.iov_len = size

        unix.process_vm_readv(_pid, local, 1, remote, 1, 0)

        return buf
    }

    fun write(address: Long, dat: Memory) {
        var local = unix.iovec()
        var remote = unix.iovec()
        val size = dat.size().toInt()

        local.iov_base = dat
        local.iov_len = size

        remote.iov_base = Pointer.createConstant(address)
        remote.iov_len = size

        unix.process_vm_writev(_pid, local, 1, remote, 1, 0)
    }
}