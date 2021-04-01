package com.algebra.xmvpdice.roll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.algebra.xmvpdice.R
import com.algebra.xmvpdice.base.BaseActivity
import com.algebra.xmvpdice.databinding.ActivityRollBinding

class RollActivity : BaseActivity<ActivityRollBinding>(), RollContract.View {
    override fun getBinding(): ActivityRollBinding {
        return ActivityRollBinding.inflate(layoutInflater)
    }

    private val presenter = RollPresenterImpl(RollInteractor())

    override fun setup() {
        presenter.bind(this)
        presenter.init()

        binding.btnRoll.setOnClickListener {
            presenter.getNewValue()
        }
    }

    override fun onDestroy() {
        presenter.unbind()
        super.onDestroy()
    }

    override fun setDiceValue(value: String) {
        binding.tvDice.text = value
    }

    override fun showInitMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.CENTER, 0, 0)
        }.show()
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.GONE
    }

}