package game

import kotlin.random.Random

enum class Direction {
    NORTH, SOUTH, EAST, WEST, START, END
}

data class Location(val x: Int = 1, val y: Int = 1)

class Game(width: Int = 8, height: Int = 8) {
    companion object {
        const val ROAD = "🔲"
        const val OBSTACLE = "🌊"
        const val CHARACTER = "🐗"
        const val GOAL = "🥜"
    }
    private val path = mutableListOf(Direction.START)
    private val map = Array(height) { y -> Array(width) { x ->
        when {
            x == width - 2 && y == width - 2 -> GOAL
            x == 0 || x == width - 1 || y == 0 || y == height - 1 -> OBSTACLE
            else -> if (Random.nextInt(width * height / (width + height)) == 0) OBSTACLE else ROAD
        }
    } }
    private val width: Int
        get() = map.first().size
    private val height: Int
        get() = map.size

    private var characterLocation = Location()
    private val currentCell: String
        get() = map[characterLocation.y][characterLocation.x]

    private val north = {
        characterLocation = characterLocation.copy(y = characterLocation.y - 1)
        path.add(Direction.NORTH)
    }
    private val south = {
        characterLocation = characterLocation.copy(y = characterLocation.y + 1)
        path.add(Direction.SOUTH)
    }
    private val east = {
        characterLocation = characterLocation.copy(x = characterLocation.x + 1)
        path.add(Direction.EAST)
    }
    private val west = {
        characterLocation = characterLocation.copy(x = characterLocation.x - 1)
        path.add(Direction.WEST)
    }
    private val end = {
        path.add(Direction.END)
        if (currentCell == GOAL) {
            println("You won!")
        }
        println("Game Over: $path")
        path.clear()
        false
    }

    private fun checkLocation() = currentCell == ROAD || end()

    fun printMap() {
        print("\u001b[H\u001b[2J")
        map.forEachIndexed { y, row ->
            row.forEachIndexed() { x, cell ->
                print(if (x == characterLocation.x && y == characterLocation.y) {
                    CHARACTER
                } else {
                    cell
                })
            }
            println()
        }
    }

    private fun move(where: () -> Boolean) = where.invoke()
    fun makeMove(move: String) = (move(when (move.lowercase()) {
        "north", "n" -> north
        "south", "s" -> south
        "east", "e" -> east
        "west", "w" -> west
        else -> end
    }) && checkLocation()).also {
        if (it) {
            printMap()
        }
    }
}

fun main() {
    val game = Game()
    game.printMap()

    while (true) {
        print("Enter a direction: n/s/e/w:")
        if (!game.makeMove(readln())) {
            break
        }
    }
}