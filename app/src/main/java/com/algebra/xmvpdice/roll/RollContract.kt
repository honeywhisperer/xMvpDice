package com.algebra.xmvpdice.roll

import com.algebra.xmvpdice.base.BaseView

interface RollContract {
    interface View : BaseView {
        fun setDiceValue(value: String)
        fun showInitMessage(message: String)
    }

    interface Presenter {
        fun bind(view: RollContract.View)
        fun unbind()
        fun getNewValue()
        fun init()
    }

    interface Model{
        fun interface OnRollFinishedListener {
            fun getNewDiceValue(value: Int)
        }

        fun interface OnRollAppInitListener{
            fun getInitMessage(message: String)
        }
    }
}