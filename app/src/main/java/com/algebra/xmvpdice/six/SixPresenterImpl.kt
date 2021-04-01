package com.algebra.xmvpdice.six

class SixPresenterImpl(private val sixInteractor: SixInteractor) : SixContract.Presenter {

    private var view: SixContract.View? = null

    override fun bind(view: SixContract.View) {
        this.view = view
    }

    override fun unbind() {
        this.view = null
    }

    override fun rollDiceAtPosition(dicePosition: Int) {
        view?.showProgress()
        sixInteractor.rollDices(dicePosition, object : SixContract.Model.RollDiceListener {
            override fun setNewValueForDice(dicePosition: Int, newValue: Int) {
                view?.hideProgress()
                view?.setNewValueDice(dicePosition, newValue.toString())
            }
        })
    }

    override fun rollAllDices() {
        (0..5).forEach {
            rollDiceAtPosition(it)
        }
    }

}