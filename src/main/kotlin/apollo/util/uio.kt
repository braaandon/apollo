package apollo.util

import com.sun.jna.*

object uio {
    init {
        Native.register(NativeLibrary.getInstance("c"))
    }

    external fun process_vm_readv(pid: Int, local: iovec, liovcnt: Long, remote: iovec, riovcnt: Long, flags: Long): Long
    external fun process_vm_writev(pid: Int, local: iovec, liovcnt: Long, remote: iovec, riovcnt: Long, flags: Long): Long
}