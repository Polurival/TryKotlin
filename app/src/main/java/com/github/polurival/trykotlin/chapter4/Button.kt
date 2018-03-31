package com.github.polurival.trykotlin.chapter4

/**
 * Листинг 4.2 Реализация простого интерфейса
 * Created by
 * Polurival on 31.03.2018.
 */
class Button: Clickable, Focusable {
    override fun click() = println("I was clicked")

    /**
     * Листинг 4.5 Вызов метода интерфейса с реализацией по умолчанию
     */
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}