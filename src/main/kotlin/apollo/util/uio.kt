package apollo.util

import com.sun.jna.Native
import com.sun.jna.NativeLibrary

object uio {
    init {
        Native.register(NativeLibrary.getInstance("c"))
    }

    external fun process_vm_readv(pid: Int, local: iovec, liovcnt: Long, remote: iovec, riovcnt: Long, flags: Long): Long
    external fun process_vm_writev(pid: Int, local: iovec, liovcnt: Long, remote: iovec, riovcnt: Long, flags: Long): Long
}
