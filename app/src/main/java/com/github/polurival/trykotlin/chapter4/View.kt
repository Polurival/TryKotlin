package com.github.polurival.trykotlin.chapter4

/**
 * Created by
 * Polurival on 31.03.2018.
 */
interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}