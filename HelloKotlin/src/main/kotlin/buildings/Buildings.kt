package buildings

sealed class BaseBuildingMaterial(var numberNeeded: Int = 1)

class Wood: BaseBuildingMaterial(4)
class Brick: BaseBuildingMaterial(8)

class Building<out T: BaseBuildingMaterial>(val baseMaterial: T) {
    var baseMaterialsNeeded: Int = 100
    val actualMaterialsNeeded: Int
        get() = baseMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        println("${baseMaterial::class.simpleName} needed: $actualMaterialsNeeded")
    }
}

fun <T: BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) {
        println("small building")
    } else {
        println("large building")
    }
}

fun main() {
    val building = Building(Wood())
    building.build()
    isSmallBuilding(building)
}