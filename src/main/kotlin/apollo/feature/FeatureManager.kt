package apollo.feature

import apollo.feature.impl.Feature;

class FeatureManager(vararg features: Feature) {
    val _features = features

    fun get(name: String): Feature {
        _features.forEach({
            if(it._name == name) {
                return it
            }
        })

        throw Exception("Module does not exist")
    }
}