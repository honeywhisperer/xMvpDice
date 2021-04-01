package com.algebra.xmvpdice.six

import com.algebra.xmvpdice.withRandomDelay
import kotlin.random.Random

class SixInteractor {

    private val diceValues = arrayOf(0, 0, 0, 0, 0, 0)

    fun rollDices(dicePosition: Int, listener: SixContract.Model.RollDiceListener) {
        var actualDicePosition: Int
        if ((dicePosition in 0..5).not()) {
            val delta = 0 - dicePosition
            actualDicePosition = delta + dicePosition
        }else{
            actualDicePosition = dicePosition
        }

        withRandomDelay(1500)
        {
            val newValue = Random.nextInt(6) + 1
            diceValues[actualDicePosition] = newValue
            listener.setNewValueForDice(actualDicePosition, newValue)
        }
    }
}