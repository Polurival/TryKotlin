package com.github.polurival.trykotlin.chapter2

import com.github.polurival.trykotlin.chapter2.Color.*

/**
 * @author Польщиков Юрий.
 */
fun main(args: Array<String>) {
    println(mix(BLUE, YELLOW))
    println(mixOptimized(BLUE, YELLOW))
}

/**
 * 2.3.3 when с произвольным объектом
 */
fun mix(c1: Color, c2: Color) {
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Грязный цвет")
    }
}

/**
 * 2.3.4 when без аргументов
 */
fun mixOptimized(c1: Color, c2: Color) {
    when {
        (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED)
        -> ORANGE
        (c1 == YELLOW && c2 == BLUE) || (c1 == BLUE && c2 == YELLOW)
        -> GREEN
        (c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE)
        -> INDIGO
        else -> throw Exception("Dirty color")
    }
}

/**
 * 2.3.5 Автоматическое приведение типов: совмещения проверки и приведения типа
 */
interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return eval(e.right as Sum) + eval((e.left))
    }
    throw IllegalArgumentException("Unknown expression")
}