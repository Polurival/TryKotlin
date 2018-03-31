package com.github.polurival.trykotlin.chapter4

/**
 * Листинг 4.6 Объявление открытого класса с открытым методом
 * Created by
 * Polurival on 31.03.2018.
 */
open class RichButton: Clickable {

    fun disable() {} // это закрытая функция, по умолчанию final

    open fun animate() {} // это открытая для переопределения функция

    //override fun click() {} // Переопределение открытой функции также является открытым

    /**
     * Листинг 4.7 Запрет переопределения открытого метода базового класса/интерфейса
     */
    final override fun click() {}
}