import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(day: Int, small: Boolean = false) =
    File("src/day$day", if (!small) "input.txt" else "small_input.txt").readLines()

fun readAll(day: Int, small: Boolean = false) =
    File("src/day$day", if (!small) "input.txt" else "small_input.txt").readText()

fun linesToInt(lines: List<String>) = lines.filter { it != "" }.map { it.toInt() }
fun linesToIntSequence(lines: List<String>, splitBy: (String) -> List<String>) =
    lines.filter { it != "" }.map { it -> splitBy(it).map { it.toInt() } }

fun linesToSequence(lines: List<String>, splitBy: (String) -> List<String>) =
    lines.filter { it != "" }.map { splitBy(it) }

fun String.textToChunks(delimiter: String) =
    this.split(delimiter).filter { it != "" }

fun String.textToRecChunks(delimiter: String, transformer: (String) -> List<Any>) =
    this.split(delimiter).filter { it != "" }.map(transformer)

fun String.textToRecChunksConvert(delimiter: String, transformer: (String) -> List<String>, converter: (String) -> Int) =
    this.split(delimiter).filter { it != "" }.map(transformer).map { it.map { el -> converter(el) } }

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

fun printSolution(day: Int, part1: Int, part2: Int, time1: Int, time2: Int) {
    println("Running day $day")
    println("\t$part1 took $time1")
    println("\t$part2 took $time2")
}
