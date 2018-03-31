package com.github.polurival.trykotlin.chapter3

/**
 * Created by
 * Polurival on 31.03.2018.
 */
fun main(args: Array<String>) {
    //saveUser(User(1, "", ""))
    saveUserWithLocalFun(User(1, "", ""))
}

class User(val id: Int, val name: String, val address: String)

/**
 * Листинг 3.11 Функция с повторяющимся кодом
 */
fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
    }

    // Сохранение информации о пользователе в базе данных
}

/**
 * Листинг 3.12 Извлечение локальной функции для предотвращения дублирования
 */
fun saveUserWithLocalFun(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address")

    // Сохранение информации о пользователе в базе данных
}

/**
 * Листинг 3.13 Доступ к параметрам внешней функции из локальной функции
 */
fun saveUserWithLocalFunOptimized(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")

    // Сохранение информации о пользователе в базе данных
}

/**
 * Листинг 3.14 Перемещение логики в функцию расширение
 */
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}
fun saveUserWithExtensionValidation(user: User) {
    user.validateBeforeSave()

    // Сохранение информации о пользователе в базе данных
}


