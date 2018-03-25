@file:JvmName("StringFunctions") // изменение имени класса в файле (по умолчанию равно имени файла + Kt)
package com.github.polurival.trykotlin.chapter3

/**
 * 3.1 Создание коллекций в Kotlin
 *
 * Created by
 * Polurival on 25.03.2018.
 */
fun main(args: Array<String>) {
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    println(joinToString(list, "; ", "(", ")"))
    println(joinToString(list, separator = "; ", prefix = "(", postfix = ")"))

    println(joinToStringWithDefaults(list))
    println(joinToStringWithDefaults(list, "; "))
    println(joinToStringWithDefaults(list, postfix = ";", prefix = "# "))

    //@JvmOverloads - если функцию с параметрами по умолчанию надо вызвать из java класса,
    // использовать даннубю аннотацию для создания перегруженных java-методов с параметрами по умолчанию
}

/**
 * 3.1 toString для Collection начальная реализация
 */
fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

/**
 * 3.2 toString для Collection с параметрами по умолчанию
 */
fun <T> joinToStringWithDefaults(
        collection: Collection<T>,
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}