package com.github.polurival.trykotlin.chapter4

/**
 * Листинг 4.11 Реализация интерфейса View с помощью вложенного класса
 * Created by
 * Polurival on 31.03.2018.
 */
class ButtonWithNestedClass: View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {}

    class ButtonState: State {} // это аналог статического вложенного класса в Java
}