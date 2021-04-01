package com.algebra.xmvpdice.six

import com.algebra.xmvpdice.base.BaseView

interface SixContract {
    interface View: BaseView{
        fun setNewValueDice(dicePosition: Int, value: String)
    }

    interface Presenter{
        fun bind(view: View)
        fun unbind()
        fun rollDiceAtPosition(dicePosition: Int)
//        fun setNewDiceValue(dicePosition: Int, newValue: Int)
    }

    interface ItemView{
        fun bind (item: String)
    }

    interface Model{
        fun interface RollDiceListener{
            fun setNewValueForDice(dicePosition: Int, newValue: Int)
        }
    }
}