package apollo

import com.sun.jna.*
import apollo.util.Process;

fun main() {
    val p = Process()

    val my_int = Memory(Int.SIZE_BYTES.toLong())
    my_int.setInt(0, 4445)
    
    p.write(0x2414565, my_int)
}