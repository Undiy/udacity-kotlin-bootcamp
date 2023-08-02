package aquarium5

data class Fish(var name: String)

fun main() {
    fishExamples()
}

fun fishExamples() {
    val fish = Fish("splashy")

    myWith(fish.name) {
        println(capitalize())
    }

    println(fish.run { name })
    println(fish.apply {})

    val fish2 = Fish("splashy").apply { name = "Sharky" }
    println(fish2.name)
}

inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}