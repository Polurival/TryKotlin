package com.github.polurival.trykotlin.chapter4

/**
 * Листинг 4.4 Другой интерфейс, реализующий тот же метод
 * Created by
 * Polurival on 31.03.2018.
 */
interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!")
}