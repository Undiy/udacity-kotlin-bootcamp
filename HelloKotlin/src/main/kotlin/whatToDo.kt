import java.util.*

fun main() {
    whatShouldIDoToday("snowing", -5)
    whatShouldIDoToday(temperature = 36)
}

fun whatShouldIDoToday(weather: String = "sunny", temperature: Int = 24) {
    print("Enter your mood: ")
    val mood = readln().lowercase(Locale.getDefault())
    println(when {
        mood == "happy" && weather == "Sunny" -> "go for a walk"
        mood == "sad" && weather == "rainy" && temperature == 0 -> "stay in bed"
        temperature > 35 -> "go swimming"
        mood == "happy" && weather == "snowing" && temperature in -10..0 -> "go skiing"
        else -> "Stay home and read."
    })
}