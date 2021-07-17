package apollo.gui

import org.lwjgl.*
import org.lwjgl.glfw.*
import org.lwjgl.opengl.*
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.opengl.GL11.*
import org.lwjgl.glfw.Callbacks.*

class Window {
    private var _errCallback : GLFWErrorCallback? = null
    private var _window: Long? = 0

    init {
        _errCallback = glfwSetErrorCallback(GLFWErrorCallback.createPrint(System.err))

        if (!glfwInit())
			throw Exception("unable to initialize GLFW");

        glfwDefaultWindowHints()
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE)
        /*
            TODO: fix this
            glfwWindowHint(GLFW_MOUSE_PASSTHROUGH, GLFW_TRUE)
        */
        glfwWindowHint(GLFW_TRANSPARENT_FRAMEBUFFER, GLFW_TRUE);
        
        _window = glfwCreateWindow(800, 600, "", 0, 0)

        if(_window == null) {
            throw Exception("glfw window creation failed")
        }

        glfwMakeContextCurrent(_window!!)
        glfwSwapInterval(1)

        glfwShowWindow(_window!!)
    }

    fun run() {
        try {
            render()
        } finally {
            cleanup()
        }
    }

    private fun render() {
		GL.createCapabilities()
        
        glClearColor(0f, 0f, 0f, 0f)

        while (!glfwWindowShouldClose(_window!!)) {
			glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT);

			glfwSwapBuffers(_window!!);
			glfwPollEvents();
		}
    }

    private fun cleanup() {
        glfwFreeCallbacks(_window!!);
		glfwDestroyWindow(_window!!);

		glfwTerminate();
    }
}