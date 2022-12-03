package day3

import readAll

fun day3() {
    fun part1(input: List<List<Char>>): Int {
        val index = ('a'..'z').zip(1..26).plus(('A'..'Z').zip(27..52)).associate { it.first to it.second }

        return input.sumOf {
            val (l, r) = it.chunked(it.size / 2)
            index[l.intersect(r.toSet()).first()]!!
        }
    }

    fun part2(input: List<List<List<Char>>>): Int {
        val index = ('a'..'z').zip(1..26).plus(('A'..'Z').zip(27..52)).associate { it.first to it.second }

        return input.sumOf {
            val its = it[0].intersect(it[1].toSet()).intersect(it[2].toSet())
            index[its.first()]!!
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readAll(3, small = true)
        .split("\n")
        .map { it.split("").filter { el -> el != "" }.map { el -> el[0] } }

    val input = readAll(3)
        .split("\n")
        .map { it.split("").filter { el -> el != "" }.map { el -> el[0] } }

    check(part1(testInput) == 157)
    println("\tPart 1: ${part1(input)}")

    check(part2(testInput.windowed(3, step = 3)) == 70)
    println("\tPart 2: ${part2(input.windowed(3, step = 3))}")
}
