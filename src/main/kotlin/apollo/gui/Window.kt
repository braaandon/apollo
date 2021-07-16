package apollo.gui

import javax.swing.*
import java.awt.EventQueue

class Window : JFrame() {
    init {
        setSize(500, 300)
        setTitle("Apollo")

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    }
}

fun CreateWindow() {
    EventQueue.invokeLater({
        Window().isVisible = true
    })
}