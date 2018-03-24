package com.github.polurival.trykotlin.chapter2

import com.github.polurival.trykotlin.chapter2.Color.*

/**
 * Котлин в действии, часть 2
 *
 * @author Польщиков Юрий.
 */

fun main(args: Array<String>) {
    println(mix(BLUE, YELLOW))
    println(mixOptimized(BLUE, YELLOW))
    println(evalJavaIf(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalKotlinIf(Sum(Num(1), Num(2))))
    println(evalWhen(Sum(Num(1), Num(3))))
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
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

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun evalJavaIf(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return evalJavaIf(e.right) + evalJavaIf((e.left)) // smart cast
    }
    throw IllegalArgumentException("Unknown expression")
}

fun evalKotlinIf(e: Expr): Int =
        if (e is Num) {
            e.value
        } else if (e is Sum) {
            evalKotlinIf(e.right) + evalKotlinIf(e.left)
        } else {
            throw IllegalArgumentException("Unknown expression")
        }

fun evalWhen(e: Expr): Int =
        when (e) {
            is Num ->
                e.value
            is Sum ->
                evalWhen(e.left) + evalWhen(e.right)
            else ->
                throw IllegalArgumentException("Unknown expression")
        }

/**
 * 2.3.7 Блоки в выражениях if и when
 */
fun evalWithLogging(e: Expr): Int =
        when (e) {
            is Num -> {
                println("num ${e.value}")
                e.value
            }
            is Sum -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                println("sum: $left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("Unknown expression")
        }