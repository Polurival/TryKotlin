package com.github.polurival.trykotlin.chapter4

/**
 * Листинг 4.1 Объявление простого интерфейса
 * Created by
 * Polurival on 31.03.2018.
 */
interface Clickable {
    fun click()

    // Листинг 4.3 Определение метода с телом в интерфейсе
    fun showOff() = println("I'm clickable!")
}