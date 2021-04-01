package com.algebra.xmvpdice.six

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.algebra.xmvpdice.base.BaseActivity
import com.algebra.xmvpdice.databinding.ActivitySixBinding

class SixActivity : BaseActivity<ActivitySixBinding>(), SixContract.View {
    override fun getBinding(): ActivitySixBinding {
        return ActivitySixBinding.inflate(layoutInflater)
    }

    private val diceAdapter = DiceAdapter()
    private val diceListener = object : OnItemDiceInteraction{
        override fun onDiceClick(dicePosition: Int) {
            presenter.rollDiceAtPosition(dicePosition)
        }
    }

    private val presenter = SixPresenterImpl(SixInteractor())

    override fun setup() {
        presenter.bind(this)
        setupRV()
        setListeners()
    }

    private fun setupRV(){
        diceAdapter.listener = diceListener
        with(binding.rvDice){
            layoutManager = GridLayoutManager(this@SixActivity, 2)
            adapter = diceAdapter
        }
        diceAdapter.initDiceValues()
    }

    private fun setListeners(){
        binding.btnRollAll.setOnClickListener {
            presenter.rollAllDices()
        }
    }

    override fun setNewValueDice(dicePosition: Int, value: String) {
        diceAdapter.setDiceValue(dicePosition, value)
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.GONE
    }

    override fun onDestroy() {
        presenter.unbind()
        super.onDestroy()
    }

}