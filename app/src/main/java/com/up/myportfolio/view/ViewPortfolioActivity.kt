package com.up.myportfolio.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.up.myportfolio.R
import com.up.myportfolio.databinding.ActivityViewPortfolioBinding

class ViewPortfolioActivity : AppCompatActivity() {

    private var binding: ActivityViewPortfolioBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_portfolio)
        binding?.lifecycleOwner = this
        initView()
    }

    private fun initView() {

    }
}