import java.util.regex.Pattern
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val data = input.map { it.split(regex = Pattern.compile(" +")).map { it.toInt() } }
        val x = data.map { it.first() }.sorted()
        val y = data.map { it.last() }.sorted()

        var sum = 0
        for (i in x.indices) {
            sum += abs(x[i] - y[i])
        }

        return sum
    }

    fun part2(input: List<String>): Int {
        val data = input.map { it.split(regex = Pattern.compile(" +")).map { it.toInt() } }
        val x = data.map { it.first() }.sorted()
        val y = data.map { it.last() }.sorted().fold(mutableMapOf<Int, Int>()) { acc, elem ->
            acc[elem] = acc.getOrDefault(elem, 0) + 1
            acc
        }

        var res = 0
        x.forEach{
            res += it * y.getOrDefault(it, 0)
        }

        return res
    }

    // Test if implementation meets criteria from the description, like:
    // check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    // Read the input from the `src/input/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
