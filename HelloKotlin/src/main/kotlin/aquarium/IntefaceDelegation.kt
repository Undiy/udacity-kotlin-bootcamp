package aquarium

fun main() {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishColor {
    val color: String
}

class Plecostomus(fishColor: FishColor = GoldColor):
        FishColor by fishColor,
        FishAction by PrintingFishAction("a lot of algae")

object GoldColor: FishColor {
    override val color = "gold"
}

object RedColor: FishColor {
    override val color = "red"
}

class PrintingFishAction(val food: String): FishAction {
    override fun eat() {
        println(food)
    }
}