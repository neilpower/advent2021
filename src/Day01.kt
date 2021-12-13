fun main() {
    fun part1(input: List<String>) = input.map { it.toInt() }.fold(Pair(-1, 0)) { pair, value ->
        Pair(value, if (value > pair.first) pair.second + 1 else pair.second)
    }.second - 1

    fun part2(input: List<String>): Int {
        val intInput = input.map { it.toInt() }
        return intInput
            .mapIndexedNotNull { index, _ -> if (index > 1) intInput[index] + intInput[index - 1] + intInput[index - 2] else null }
            .fold(Pair(0, -1)) { pair, value ->
                Pair(
                    value, if (value > pair.first) pair.second + 1 else pair.second
                )
            }.second
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    println(part1(testInput))
    check(part1(testInput) == 7)
    println(part2(testInput))
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
