package com.github.polurival.trykotlin.chapter1

/**
 * Created by
 * Polurival on 18.02.2018.
 */
data class Person(val name: String,
                  val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"),
            Person("Bob", age = 29))

    val oldest = persons.maxBy { it.age ?: 0 }
    println("The oldest is: $oldest")
}