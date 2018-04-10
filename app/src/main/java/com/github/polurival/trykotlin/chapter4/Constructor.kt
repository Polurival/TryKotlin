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
class Context // это просто заглушки

class AttributeSet

/**
 * класс с вторичными конструкторами
 */
open class View1 {
    constructor(ctx: Context) {
        // некоторый код
    }

    constructor(ctx: Context, attr: AttributeSet) {
        // некоторый код
    }
}

/**
 * вызов конструкторов суперкласса
 */
class MyButton : View1 {
    constructor(ctx: Context) : super(ctx) { // можно вызвать один конструктор из другого : this(ctx, MY_STYLE)
        // некоторый код
    }

    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {
        // некоторый код
    }
}

/**
 * 4.2.3 Реализация свойств, объявленных в интерфейсах
 */
interface User1 {
    val nickname: String
}

/**
 * Реализация свойств интерфейса
 */
class PrivateUser(override val nickname: String) : User1 // свойство основного конструктора. Имеет поле для хранения значения

class SubscribingUser(val email: String) : User1 {
    override val nickname: String // не имеет поля для хранения значения
        get() = email.substringBefore('@') // собственный метод чтения
}

class FacebookUser(val accountId: Int) : User1 {
    override val nickname = getFacebookName(accountId) // инициализация свойства. Имеет поле для хранения значения
}

fun getFacebookName(accountId: Int): String {
    return accountId.toString()
}

/**
 * первое свойство должно быть переопределено в подклассах
 * второе может быть унаследовано
 */
interface User3 {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}


/**
 * 4.2.4 Обращение к полю из методов доступа
 */
class User4(val name: String) {
    var address: String = "unspecified"
        set(value) {
            println("""Address was changed for $name: "$field" -> "$value".""".trimIndent()) // чтение значения поля
            field = value // изменение значения поля
        }
}


class LengthCounter {
    var counter: Int = 0 // значение этого свойства нельзя изменить вне класса
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}
