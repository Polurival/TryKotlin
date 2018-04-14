package com.github.polurival.trykotlin.chapter4

import com.github.polurival.trykotlin.chapter1.Person
import java.io.File

/**
 * 4.4 Ключевое слово object: совместное объявление класса и его экземпляра
 * Created by
 * Polurival on 13.04.2018.
 */
fun main(args: Array<String>) {
    Payroll.allEmployees.add(Person("noName"))
    Payroll.calculateSalary()

    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))

    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val persons = listOf(PersonWithComparator("Bob"), PersonWithComparator("Alice"))
    println(persons.sortedWith(PersonWithComparator.NameComparator))

    A.bar()

    val subscribingUser = User6.newSubscribingUser("bob@gmail.com")
    val facebookUser = User6.newFacebookUser(4)
    println(subscribingUser.nickname)
}

/**
 * 4.4.1 Объединение объекта: простая реализация шаблона "Одиночка"
 */
object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
    }
}

/**
 * Листинг 4.23. Реализация интерфейса Comparator с помощью объявления объекта
 */
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

/**
 * Листинг 4.24. Реализация интерфейса Comparator как вложеного объекта
 */
data class PersonWithComparator(val name: String) {
    object NameComparator : Comparator<PersonWithComparator> {
        override fun compare(p1: PersonWithComparator, p2: PersonWithComparator): Int = p1.name.compareTo(p2.name)
    }
}

/**
 * 4.4.2. Объекты-компаньоны: место для фабричных методов и статических членов класса
 */
class A {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

/**
 * Листинг 4.25. Определение класса с несколькими вторичными конструкторами
 */
class User5 {
    val nickname: String

    constructor(email: String) {
        nickname = email.substringBefore('@')
    }

    constructor(facebookAccountId: Int) {
        nickname = getFacebookName(facebookAccountId)
    }
}

/**
 * Листинг 4.26. Замещение вторичных конструкторов фабричными методами
 */
class User6 private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) = User6(email.substringBefore('@'))
        fun newFacebookUser(accountId: Int) = User6(getFacebookName(accountId))
    }
}

/**
 * Листинг 4.27. Объявление именованного объекта-компаньона
 */