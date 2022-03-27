package com.example.exchangerate.model.activity

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import androidx.fragment.app.FragmentTransaction
import com.example.exchangerate.R
import com.example.exchangerate.databinding.ToolbarBinding
import com.example.exchangerate.model.App
import com.example.exchangerate.model.fragment.BaseFragment
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity : AppCompatActivity(){
    abstract var fragment: BaseFragment // var - чтобы обеспечить будущее изменение фрагмента
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var toolBarBinding: ToolbarBinding
    open val contentView = R.layout.base_layout_new1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent()
        App.appComponent.inject(this)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        addFragment(savedInstanceState)

    }
    open fun setContent(){
        setContentView(contentView)
    }
    fun addFragment(savedInstanceState: Bundle?, fragment: BaseFragment = this.fragment) {
        savedInstanceState ?: supportFragmentManager.inTransaction {
            add(R.id.fragmentContainer, fragment)
        }
        }

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
        beginTransaction().func().commit()

    inline fun <reified T : ViewModel> viewModel(body: T.() -> Unit): T {
        val vm: T = ViewModelProvider(this, viewModelFactory).get(T::class.java)
        vm.body()
        return vm
    }
    inline fun Activity?.base(block: BaseActivity.() -> Unit) = (this as? BaseActivity)?.let(block)

    open fun finishWork(){
        finishAndRemoveTask()
        System.exit(0)
        finish()
    }
}