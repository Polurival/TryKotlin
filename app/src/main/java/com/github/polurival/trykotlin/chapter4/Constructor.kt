package com.github.polurival.trykotlin.chapter4

/**
 * 4.2.1 Инициализация классов: основной конструктор и блоки инициализации
 * Created by
 * Polurival on 03.04.2018.
 */
fun main(args: Array<String>) {
    val alice = User2("Alice")
    println(alice.isSubscribed)

    val bob = User2("Bob", false)
    println(bob.isSubscribed)

    val carol = User2("Carol", isSubscribed = false)
    println(carol.isSubscribed)
}

/*class User2 constructor(_nickname: String) {

    val nickname: String

    init {
        nickname = _nickname
    }
}*/

/*class User(_nickname: String) {
    val nickname = _nickname
}*/

/**
 * эквивалентно двум верхним примерам
 */
class User(val nickname: String)

class User2(val nickname: String,
            val isSubscribed: Boolean = true) // параметр по умолчанию в конструкторе

open class SuperUser(val nickname: String)

class TwitterUser(nickname: String) : SuperUser(nickname)

open class ButtonWithoutConstructor // будет сгенерирован конструтор по умолчанию

class RadioButton : ButtonWithoutConstructor()

class Secretive private constructor() // приватный конструктор

// 4.2.2 Вторичные конструкторы: различные способы инициализации суперкласса
