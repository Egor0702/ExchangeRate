package com.example.exchangerate.model.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangerate.R
import com.example.exchangerate.model.App
import com.example.exchangerate.model.adapter.BaseAdapter
import com.example.exchangerate.model.adapter.PopularAdapter
import com.example.exchangerate.model.onSuccess
import com.example.exchangerate.model.viewmodel.ViewModelPopular

class PopularFragment : BaseFragment() {
    override val layoutId = R.layout.inner_fragment_list
    override lateinit var recyclerView: RecyclerView
    override lateinit var lm: RecyclerView.LayoutManager
    override val viewAdapter = PopularAdapter()
    lateinit var popular: ViewModelPopular

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)

        popular = viewModel {
            onSuccess(mapResponse,:: handleMapResponse)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lm = LinearLayoutManager(context)
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true) // этим методом мы устанавливаем, что размер адаптера не должен влиять на размер recyclerview
            layoutManager = lm // усьанавливаем горизонтальную ориентацию
            adapter = viewAdapter
        }

        popular.getInfoRate()

    }
    private fun handleMapResponse(requests: MutableMap<String, Double>?) { // в случае, если список на который мы подписаны обновлен, выполняются действия:
        requests?.let {
            viewAdapter.clear() // очищаем имеющийся список в recyclerview
            viewAdapter.add(requests) // добавляем новый список
            viewAdapter.notifyDataSetChanged() // бновляем данные, чтобы они отобразились на экране пользователя
        }
    }
}