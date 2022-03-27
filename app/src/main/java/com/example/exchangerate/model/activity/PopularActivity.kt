package com.example.exchangerate.model.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.exchangerate.R
import com.example.exchangerate.databinding.BaseLayoutNew1Binding
import com.example.exchangerate.model.fragment.BaseFragment
import com.example.exchangerate.model.fragment.PopularFragment
import kotlinx.android.synthetic.main.toolbar.*


class PopularActivity : BaseActivity() {
    override var fragment: BaseFragment = PopularFragment()
    lateinit var baseLayoutNewBinding: BaseLayoutNew1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.menu) // устанавливаем изображение для открытия меню
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // устанавливаем видимость установленного выше изображения
    }


}