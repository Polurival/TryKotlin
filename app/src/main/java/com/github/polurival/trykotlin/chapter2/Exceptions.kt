package com.github.polurival.trykotlin.chapter2

import java.io.BufferedReader
import java.io.StringReader

/**
 * 2.5 Исключения в Kotlin
 *
 * @author Polurival on 24.03.2018.
 */
fun main(args: Array<String>) {
    //checkPercentage(200)

    val reader = BufferedReader(StringReader("239"))
    println(readNumberLikeJava(reader))

    val reader2 = BufferedReader(StringReader("not a number"))
    readNumberTryLikeExpression(reader2)
    readNumberTryCatchReturnVal(reader2)
}

fun checkPercentage(number: Int) {
    val percentage =
            if (number in 0..100)
                number
            else
                throw IllegalArgumentException("A percentage value must between 0 and 100: $number")
    println(percentage)
}

/**
 * 2.27 Использование try как в Java
 */
fun readNumberLikeJava(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

/**
 * 2.28 Использование try в качестве выражения
 */
fun readNumberTryLikeExpression(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    }
    println(number)
}

/**
 * 2.29 Возврат значения из блока catch
 */
fun readNumberTryCatchReturnVal(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }
    println(number)
}