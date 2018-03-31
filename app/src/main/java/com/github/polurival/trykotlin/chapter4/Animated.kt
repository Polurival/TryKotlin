package com.github.polurival.trykotlin.chapter4

/**
 * Листинг 4.8 Объявление абстрактного класса
 * Created by
 * Polurival on 31.03.2018.
 */
abstract class Animated {

    abstract fun animate()

    open fun stopAnimating() {}

    fun animateTwice() {}
}