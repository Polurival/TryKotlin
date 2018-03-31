package com.github.polurival.trykotlin.chapter4

/**
 * Created by
 * Polurival on 31.03.2018.
 */
fun main(args: Array<String>) {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}
//fun TalkativeButton.giveSpeech() { // надо сделать internal этот метод либо класс сделать public
//yell() // нельзя вызвать в функции расширении закрытый или protected методы
//whisper()
//}

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer // получение доступа к классу Outer из класса Inner
    }
}

/**
 * Листинг 4.13 Выражения в виде запечатанных классов
 */
sealed class Expr { // класс Expr могут наследовать только вложенные классы благодаря sealed
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int =
        when (e) {
            is Expr.Num -> e.value
            is Expr.Sum -> eval(e.left) + eval(e.right)
        }
