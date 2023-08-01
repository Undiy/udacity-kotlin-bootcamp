fun main() {
//    for (i in 1..10) {
//        val birthday = getBirthday()
//        val fortune = getFortune(birthday)
//        println("Your fortune is: $fortune")
//        if (fortune == "Take it easy and enjoy life!") {
//            break
//        }
//    }
//    repeat(10) {
//        val birthday = getBirthday()
//        val fortune = getFortune(birthday)
//        println("Your fortune is: $fortune")
//        if (fortune == "Take it easy and enjoy life!") {
//            return
//        }
//    }

    var fortune = ""
    while (fortune != "Take it easy and enjoy life!") {
        val birthday = getBirthday()
        fortune = getFortune(birthday)
        println("Your fortune is: $fortune")
    }
}

fun getFortune(birthday: Int): String {
    val fortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.")

    return when {
        birthday == 28 || birthday == 31 -> "The future is dim"
        birthday < 8 -> "Early bird gets the prize"
        else -> fortunes[birthday % fortunes.size]
    }
}

fun getBirthday(): Int {
    print("Enter your birthday: ")
    return readln().toIntOrNull() ?: 42
}
