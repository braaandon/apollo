package apollo.feature

import apollo.feature.impl.Feature;

class FeatureManager(vararg features: Feature) {
    val features = features

    fun get(name: String): Feature {
        features.forEach({
            if(it.name == name) {
                return it
            }
        })

        throw Exception("Module does not exist")
    }
}