package apollo.feature.impl

open class Feature(name: String) {
    val name = name

    open fun on_loop() { /*...*/ }
}
