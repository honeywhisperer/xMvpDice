package com.algebra.xmvpdice.roll

import com.algebra.xmvpdice.withDelay
import kotlin.random.Random

class RollInteractor {

    private var diceValue: Int = 0
    private var initMessage = "Press Roll button to start"

    fun roll(listener: RollContract.Model.OnRollFinishedListener) {
        withDelay(1000) {
            diceValue = Random.nextInt(6) + 1
            listener.getNewDiceValue(diceValue)
        }
    }

    fun init(listener: RollContract.Model.OnRollAppInitListener) {
        withDelay(500) {
            listener.getInitMessage(initMessage)
        }
    }
}