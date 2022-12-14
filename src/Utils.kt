import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import javax.xml.transform.Transformer

/**
 * Reads lines from the given input txt file.
 */
fun readInput(day: Int, small: Boolean = false) =
    File("src/day$day", if (!small) "input.txt" else "small_input.txt").readLines()

fun readAll(day: Int, small: Boolean = false) =
    File("src/day$day", if (!small) "input.txt" else "small_input.txt").readText()

fun linesToInt(lines: List<String>) = lines.filter { it != "" }.map { it.toInt() }
fun List<String>.linesToIntSequence(splitBy: (String) -> List<String>) =
    this.filter { it != "" }.map { it -> splitBy(it).map { it.toInt() } }

fun List<String>.linesToAsciiSequence(delimiter: String) =
    this.map { it.split(delimiter).filter { el -> el != "" }.map { el -> el[0].code } }

fun linesToSequence(lines: List<String>, splitBy: (String) -> List<String>) =
    lines.filter { it != "" }.map { splitBy(it) }

/**
 * Converts text to chunks by splitting on a delimiter.
 */
fun String.textToChunks(delimiter: String) =
    this.split(delimiter).filter { it != "" }

/**
 * Converts text to chunks by splitting on a delimiter and transforms the results.
 */
fun String.textToRecChunks(delimiter: String, transformer: (String) -> List<Any>) =
    this.split(delimiter).filter { it != "" }.map(transformer)

/**
 * Converts text to chunks by splitting on a delimiter, transforms the results and converts elements to Int.
 */
fun String.textToRecChunksConvert(delimiter: String, transformer: (String) -> List<String>, converter: (String) -> Int) =
    this.split(delimiter).filter { it != "" }.map(transformer).map { it.map { el -> converter(el) } }

fun String.textToTuplesRegex(delimiter: String, re: Regex): List<List<String>> {
    return this.split(delimiter).filter { it != "" }.map { it.split(re) }
}

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
