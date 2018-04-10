package com.github.polurival.trykotlin.chapter4

/**
 * 4.3 классы данных и делегирование
 * Created by
 * Polurival on 07.04.2018.
 */
fun main(args: Array<String>) {
    val bob = Client("Bob", 973293)
    println(bob.copy(postalCode = 382555))
}

/**
 * Листинг 4.17
 */
class Client(val name: String, val postalCode: Int) {

    /**
     * Листинг 4.18
     */
    override fun toString() = "Client(name=$name, postalCode=$postalCode"

    /**
     * Листинг 4.19
     */
    override fun equals(other: Any?): Boolean {
        return if (other == null || other !is Client) {
            false
        } else {
            name == other.name && postalCode == other.postalCode
        }
    }

    /**
     * Листинг 4.20
     */
    override fun hashCode() = name.hashCode() * 31 + postalCode

    fun copy(name: String = this.name,
             postalCode: Int = this.postalCode) =
            Client(name, postalCode)
}

/**
 * Листинг 4.21. Класс Client как класс данных
 */
data class Client2(val name: String, val postalCode: Int)


// 4.3.3 Делегирование в классах. Ключевое слово by
