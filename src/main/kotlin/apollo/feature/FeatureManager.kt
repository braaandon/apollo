package apollo.feature

import apollo.feature.impl.Feature;

class FeatureManager(vararg features: Feature) {
    val _features = features

    fun forEach(fn: (feat: Feature) -> Unit) {
        _features.forEach { fn(it) }
    }

    inline fun <reified T> get(): Feature {
        _features.forEach({
            if(it is T) {
                return it
            }
        })

        throw Exception("Module does not exist")
    }
}