package aquarium

fun main() {
    buildAquarium()
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    println("Length: ${myAquarium.length} " +
            "Width: ${myAquarium.width} " +
            "Height: ${myAquarium.height}")

    myAquarium.height = 80

    println("Height: ${myAquarium.height}")
    println("Volume: ${myAquarium.volume}")

    val smallAquarium = Aquarium(20, 15, 30)
    println("Small aquarium volume: ${myAquarium.volume}")

    val myAquarium2 = Aquarium(9)
    println("Small aquarium 2: ${myAquarium2.volume} litres with " +
            "Length: ${myAquarium2.length} " +
            "Width: ${myAquarium2.width} " +
            "Height: ${myAquarium2.height}")

    makeFish()

}

fun makeFish() {
    val shark = Shark()
    val pleco = Plectostomus()

    println("Shark: ${shark.color}\nPlectostomus: ${pleco.color}")

    shark.eat()
    pleco.eat()
}