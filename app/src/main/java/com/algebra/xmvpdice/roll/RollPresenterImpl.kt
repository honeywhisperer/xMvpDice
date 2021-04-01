package com.algebra.xmvpdice.roll

class RollPresenterImpl(private val interactor: RollInteractor) : RollContract.Presenter {

    private var view: RollContract.View? = null

    override fun bind(view: RollContract.View) {
        this.view = view
    }

    override fun unbind() {
        this.view = null
    }

    override fun getNewValue() {
        view?.showProgress()
        interactor.roll { value ->
            view?.hideProgress()
            view?.setDiceValue(value.toString())
        }
    }

    override fun init() {
        view?.showProgress()
        interactor.init { message ->
            view?.hideProgress()
            view?.showInitMessage(message)
        }
    }

//    override fun getNewValue() {
//        view?.showProgress()
//        interactor.roll(object : RollContract.OnRollFinishedListener{
//            override fun getNewDiceValue(value: Int) {
//                view?.hideProgress()
//                view?.setDiceValue(value.toString())
//            }
//        })
//    }

//    override fun init() {
//        view?.showProgress()
//        interactor.init(object : RollContract.OnRollAppInitListener{
//            override fun getInitMessage(message: String) {
//                view?.hideProgress()
//                view?.showInitMessage(message)
//            }
//        })
//    }


}