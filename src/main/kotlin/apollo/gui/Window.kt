package apollo.gui

import javax.swing.*

class Window : JFrame() {
    init {
        setTitle("Apollo")
        setSize(600, 400)
        setLocationRelativeTo(null)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    }

    fun render() {
        isVisible = true;
    }
}