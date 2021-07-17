package apollo.feature.impl

open class Feature(name: String) {
    var _name = name;
    
    open fun on_loop() { /*...*/ }
}