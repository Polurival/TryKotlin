package com.github.polurival.trykotlin.chapter2

import java.util.*

/**
 * @author Polurival on 24.03.2018.
 */
fun main(args: Array<String>) {

    // 2.22
    for (i in 1..100) {
        print(fizzBuzz(i))
    }
    println()

    //2.23 итерация по диапазону с шагом
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }
    println()

    // 2.24 Создание словаря и обход его элементов
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    // Обход коллекции с сохранением индекса
    val list = arrayListOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }

    println(isLetter('q'))
    println(isNotDigit('x'))

    println(recognize('8'))

    // in может работать с любыми объектами, реализирующими Comparable
    println("Kotlin" in "Java".."Scala")
    println("Kotlin" in setOf("Java", "Scala"))
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

/**
 * 2.25 Проверка вхождения в диапазон с помощью in
 */
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isNotDigit(c: Char) = c !in '0'..'9'

/**
 * 2.26 Использование проверки in в ветках when
 */
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z' -> "It's a letter"
    else -> "I don't know..."
}