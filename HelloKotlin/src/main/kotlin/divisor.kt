fun <T: Number> Collection<T>.divisibleBy(division: (T) -> Int) = filter { division(it) == 0 }
fun <T: Number> Collection<T>.divisibleBy3() = divisibleBy { it.toInt() % 3}


fun main(){
    println(listOf<Int>(1,2,3,4,5,6,7,8,9,0).divisibleBy3())
}