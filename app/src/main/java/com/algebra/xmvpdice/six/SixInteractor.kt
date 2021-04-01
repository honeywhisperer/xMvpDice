package com.algebra.xmvpdice.six

import com.algebra.xmvpdice.withRandomDelay
import kotlin.random.Random

class SixInteractor {

    private val diceValues = arrayOf(0, 0, 0, 0, 0, 0)

    fun rollDices(dicePosition: Int, listener: SixContract.Model.RollDiceListener) {
        withRandomDelay(1500)
        {
            val newValue = Random.nextInt(6) + 1
            diceValues[dicePosition] = newValue
            listener.setNewValueForDice(dicePosition, newValue)
        }
    }
}