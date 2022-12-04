package day4

import linesToIntSequence
import readAll

fun day4() {
    fun part1(input: List<List<Int>>): Int {
        return input.sumOf {
            when {
                it[0] - it[2] <= 0 && it[1] - it[3] >= 0 -> 1
                it[0] - it[2] >= 0 && it[1] - it[3] <= 0 -> 1
                else -> 0.toInt()
            }
        }
    }

    fun part2(input: List<List<Int>>): Int {
        return input.sumOf {
            when {
                (it[0]..it[1]).intersect(it[2]..it[3]).isNotEmpty() -> 1
                else -> 0.toInt()
            }
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readAll(4, small = true)
        .split("\n")
        .linesToIntSequence { line -> line.split(Regex("[-,]")) }

    val input = readAll(4)
        .split("\n")
        .linesToIntSequence { line -> line.split(Regex("[-,]")) }

    check(part1(testInput) == 2)
    println("\tPart 1: ${part1(input)}")

    check(part2(testInput) == 4)
    println("\tPart 2: ${part2(input)}")
}
