package com.github.polurival.trykotlin.chapter3

/**
 * Created by
 * Polurival on 31.03.2018.
 */

fun main(args: Array<String>) {

    parsePath("/Users/yole/kotlin-book/chapter.adoc")
    parsePathRegex("/Users/yole/kotlin-book/chapter.adoc")

    // 3.5.3 Многостраничные литералы в тройных кавычках
    val kotlinLogo = """\ //
                       .\//
                       .\/ \"""
    println(kotlinLogo.trimMargin("."))

    val price = """${'$'}99.9"""
    println(price)
}

/**
 * Листинг 3.9 Использование расширений класса String для работы с путями и файлами
 */
fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}

/**
 * Использование регулярных выражений для разбора пути к файлу
 */
fun parsePathRegex(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir: $directory, name: $fileName, ext: $extension")
    }
}