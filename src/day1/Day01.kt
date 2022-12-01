package day1

import readAll
import textToRecChunksConvert

fun day1() {
    fun part1(input: List<List<Int>>): Int {
        return input.map { it.sum() }.max()
    }

    fun part2(input: List<List<Int>>): Int {
        return input.map { it.sum() }.sorted().reversed().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readAll(1, small = true)
        .textToRecChunksConvert(delimiter = "\n\n", transformer = { it.split("\n") }) { it.toInt() }
    check(part1(testInput) == 24_000)

    val input = readAll(1)
        .textToRecChunksConvert(delimiter = "\n\n", transformer = { it.split("\n") }) { it.toInt() }
    check(part2(testInput) == 45_000)
    println("\tPart 1: ${part1(input)}")
    println("\tPart 2: ${part2(input)}")
}
