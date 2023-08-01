sealed class Spice(
    var name: String,
    var spiciness: String
) {
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

    abstract fun prepareSpice()
}

class Curry(color: SpiceColor = YellowSpiceColor) : Spice("curry", "mild"),
    Grinder,
    SpiceColor by color {
    override fun prepareSpice() {
        super.grind()
    }
}
class Salt : Spice("salt", "bland"), Grinder {
    override fun prepareSpice() {
        super.grind()
    }
}

interface Grinder {
    fun grind() {
        println("grinding... done")
    }
}

interface SpiceColor {
    val color: Color
}

object YellowSpiceColor : SpiceColor {
    override val color = Color.YELLOW
}

class SpiceContainer(private val spice: Spice) {
    val label: String
        get() = spice.name
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF),
    YELLOW(0xFFFF00);
}

fun main() {
    val spices = listOf(Curry(), Salt())
    val containers = spices.map { SpiceContainer(it) }.forEach {
        println(it.label)
    }
}