package com.example.exchangerate.model.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangerate.model.activity.BaseActivity
import com.example.exchangerate.model.adapter.BaseAdapter
import com.example.exchangerate.model.base
import javax.inject.Inject

abstract class BaseFragment : Fragment() {
    abstract val layoutId: Int
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    abstract var recyclerView: RecyclerView
    abstract var lm: RecyclerView.LayoutManager

    protected abstract val viewAdapter: BaseAdapter<*>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(layoutId, container, false)
    }

    inline fun <reified T : ViewModel> viewModel(body: T.() -> Unit): T {
        val vm = ViewModelProvider(this, viewModelFactory)[T::class.java]
        vm.body()
        return vm
    }
    inline fun base(block: BaseActivity.() -> Unit) = activity.base(block) // activity== getActivity()
}