package com.algebra.xmvpdice

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

fun withDelay(timeDelay: Long, predicate: () -> Unit) {
    CoroutineScope(IO).launch {
        delay(timeDelay)
        CoroutineScope(Main).launch {
            predicate()
        }
    }
}

fun withRandomDelay(timeDelay: Long, predicate: () -> Unit) {
    CoroutineScope(IO).launch {
        val actualDelayTime =
            (timeDelay * 0.2).toLong() + Random.nextLong((timeDelay * 0.8).toLong())
        delay(actualDelayTime)
        CoroutineScope(Main).launch {
            predicate()
        }
    }
}

fun String.convertToDiceFace(): String {
    return when (this) {
        "1" -> "⚀"
        "2" -> "⚁"
        "3" -> "⚂"
        "4" -> "⚃"
        "5" -> "⚄"
        "6" -> "⚅"
        else -> "?"
    }
}