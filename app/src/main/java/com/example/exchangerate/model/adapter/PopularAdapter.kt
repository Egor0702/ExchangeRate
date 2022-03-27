package com.example.exchangerate.model.adapter

import android.view.View
import com.example.exchangerate.R
import com.example.exchangerate.databinding.RecyclerItemBinding

class PopularAdapter : BaseAdapter<PopularAdapter.PopularAdapterHolder>() {
    lateinit var recyclerItemBinding: RecyclerItemBinding
    override val layoutRes = R.layout.recycler_item

    override fun createHolder(view: View, viewType: Int): PopularAdapter.PopularAdapterHolder {
        recyclerItemBinding = RecyclerItemBinding.bind(view)
        return PopularAdapterHolder(view, recyclerItemBinding)
    }
    class PopularAdapterHolder (view: View, val recyclerItemBinding: RecyclerItemBinding) : BaseViewHolder(view){
        override fun onBind(name: String, valueNumber: Double?) {
            recyclerItemBinding.apply {
                key.text= name
                value.text= valueNumber.toString()
            }
        }

    }

}