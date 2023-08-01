class SimpleSpice {
    var name: String = "curry"
    var spiciness: String = "mild"
    val heat: Int
        get() = if (spiciness == "mild") {
            5
        } else {
            0
        }
}

class Spice(
    var name: String = "curry",
    var spiciness: String = "mild") {
    val heat: Int
        get() = when (spiciness)  {
            "hot" -> 10
            "mild" -> 5
            "bland" -> 1
            else -> 0
        }

    init {
        println("Name: $name, spiciness: $spiciness, heat: $heat")
    }
}

fun makeSalt() = Spice("salt", "bland")

fun main() {
    val spice = SimpleSpice()

    println("Spiciness: ${spice.spiciness}, heat: ${spice.heat}")

    val spices = listOf(Spice(), makeSalt(), Spice("cayene", "hot"))
}