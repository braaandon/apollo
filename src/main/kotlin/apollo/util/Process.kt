package apollo.util

import com.sun.jna.Memory
import com.sun.jna.Pointer
import java.io.File

open class Process(proc: String) {
    var pid: Int = 0

    init {
        File("/proc/").listFiles().forEach {
            val pid = it.path
                .substring(6)
                .toIntOrNull()

            if (pid == null) {
                return@forEach
            }

            if (proc in
                File("/proc/$pid/cmdline").readText()
            ) {
                this.pid = pid
            }
        }

        if (pid < 0) {
            throw Exception("found no process")
        }
    }

    fun read(address: Long, size: Int): Memory {
        var local = iovec()
        var remote = iovec()
        var buf = Memory(size.toLong())

        local.iov_base = buf
        local.iov_len = size

        remote.iov_base = Pointer.createConstant(address)
        remote.iov_len = size

        uio.process_vm_readv(pid, local, 1, remote, 1, 0)

        return buf
    }

    fun write(address: Long, dat: Memory) {
        var local = iovec()
        var remote = iovec()
        val size = dat.size().toInt()

        local.iov_base = dat
        local.iov_len = size

        remote.iov_base = Pointer.createConstant(address)
        remote.iov_len = size

        uio.process_vm_writev(pid, local, 1, remote, 1, 0)
    }

    fun resolveMultiLvl(address: Long, offsets: ArrayList<Short>): Long {
        var res = address

        for (offset in offsets) {
            res = read(res, Long.SIZE_BYTES).getLong(0)
            res += offset
        }

        return res
    }

    fun getModule(mod: String): Long {
        val reader = File("/proc/$pid/maps").bufferedReader()

        for (line in reader.readLines()) {
            if (line.contains(mod)) {
                return line.substring(
                    0,
                    line.indexOf("-")
                ).toLong(radix = 16)
            }
        }

        throw Exception("$mod could not be found")
    }
}
