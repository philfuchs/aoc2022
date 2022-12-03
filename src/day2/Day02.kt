package day2

import readAll
import textToTuplesRegex

fun day2() {
    fun part1(input: List<List<String>>): Int {
        return input.sumOf {
            val l = it[0].first().code % ('A'.code - 1)
            val r = it[1].first().code % ('X'.code - 1)

            when {
                l == 1 && r == 2 -> r + 6
                l == 2 && r == 3 -> r + 6
                l == 3 && r == 1 -> r + 6
                l == r -> r + 3
                else -> r
            }
        }
    }

    fun part2(input: List<List<String>>): Int {
        return input.sumOf {
            val l = it[0].first().code % ('A'.code - 1)
            var r = it[1].first().code % ('X'.code - 1)

            r = when (r) {
                1 -> mapOf(1 to 3, 2 to 1, 3 to 2)[l]!!
                2 -> l
                else -> mapOf(1 to 2, 2 to 3, 3 to 1)[l]!!
            }

            when {
                l == 1 && r == 2 -> r + 6
                l == 2 && r == 3 -> r + 6
                l == 3 && r == 1 -> r + 6
                l == r -> r + 3
                else -> r
            }
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readAll(2, small = true)
        .textToTuplesRegex("\n", Regex(" "))

    val input = readAll(2)
        .textToTuplesRegex("\n", Regex(" "))

    check(part1(testInput) == 15)
    println("\tPart 1: ${part1(input)}")

    check(part2(testInput) == 12)
    println("\tPart 2: ${part2(input)}")
}
