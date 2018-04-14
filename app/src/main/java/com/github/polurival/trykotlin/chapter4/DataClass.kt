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
/**
 * Недостаток паттерна декоратор - большой объем шаблонного кода
 */
class DelegatingCollection<T> : Collection<T> {
    private val innerList = arrayListOf<T>()

    override val size: Int get() = innerList.size
    override fun contains(element: T): Boolean = innerList.contains(element)
    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)
    override fun isEmpty(): Boolean = innerList.isEmpty()
    override fun iterator(): Iterator<T> = innerList.iterator()
}

/**
 * Ключевое слово by генерирует реализацию методов интерфейса
 */
class DelegatingCollectionBy<T>(
        innerList: Collection<T> = ArrayList()
) : Collection<T> by innerList

/**
 * Листинг 4.22 Делегирование реализации объекту innerSet с собственной реализацией некоторых методов
 */
class CountingSet<T>(
        val innerSet: MutableCollection<T> = HashSet()
) : MutableCollection<T> by innerSet {

    var objectAdded = 0

    override fun add(element: T): Boolean {
        objectAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }
}