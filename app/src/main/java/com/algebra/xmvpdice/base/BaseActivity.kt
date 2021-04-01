package com.algebra.xmvpdice.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {
    private var _binding : VB? = null
    protected val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getBinding()
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setup()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    internal abstract fun getBinding(): VB
    abstract fun setup()
}