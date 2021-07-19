package apollo.feature.impl

import apollo.sdk.Game

open class Feature(name: String) {
    val name = name
    val game = Game()

    open fun on_loop() { /*...*/ }
}
